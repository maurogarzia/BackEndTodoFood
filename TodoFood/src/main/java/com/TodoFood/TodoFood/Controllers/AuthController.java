package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.User;
import com.TodoFood.TodoFood.Entities.enums.Rol;
import com.TodoFood.TodoFood.Repositories.UserRepository;
import com.TodoFood.TodoFood.jwt.JwtUtils;
import com.TodoFood.TodoFood.payload.AuthRequest;
import com.TodoFood.TodoFood.payload.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("todoFood/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager; // Se encarga de autenticar users

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> login  (@RequestBody AuthRequest req){
        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
            UserDetails user = (UserDetails) auth.getPrincipal(); // Extrae el objeto userDetails
            String token = jwtUtils.tokenGenerate(user);
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        }catch(AuthenticationException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }

    // Metodo que valida que el usuario esta autenticado
    private boolean isAdminauthenticated() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth != null && auth.isAuthenticated() &&
                auth.getAuthorities().stream()
                        .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
    }


    @PostMapping("/register")
    public ResponseEntity<?> register (@RequestBody RegisterRequest reg) {
        try{
            // validar si el usuario ya existe
            if (userRepository.findByUsername(reg.getUsername()).isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El nombre de usuario ya esta registrado");
            }

            // Crea nuevo usuario
            User user = new User();
            user.setName(reg.getName());
            user.setLastname(reg.getLastname());
            user.setUsername(reg.getUsername());
            user.setEmail(reg.getEmail());
            user.setPassword(passwordEncoder.encode(reg.getPassword()));

            String requiredRol = reg.getRole();

            if (requiredRol == null || requiredRol.trim().isEmpty()){
                user.setRole(Rol.CUSTOMER); // Seteo customer por defecto
            } else if(requiredRol.equalsIgnoreCase("ADMIN")){

                // Valido si el usuario tiene permisos
                if (isAdminauthenticated()){
                    user.setRole(Rol.ADMIN);
                } else {
                    return ResponseEntity.status(HttpStatus.FORBIDDEN)
                            .body("NO tenes permisos para crear un usuario admin");
                }

            } else {
                user.setRole(Rol.CUSTOMER);
            }

            userRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" + e.getMessage());
        }
    }


}
