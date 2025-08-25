package com.TodoFood.TodoFood.Controllers;

import com.TodoFood.TodoFood.Entities.User;
import com.TodoFood.TodoFood.Services.UserService;
import com.TodoFood.TodoFood.dtos.RequestPatchUser;
import com.TodoFood.TodoFood.payload.PasswordChangeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/todoFood/user")
public class UserController extends BaseController<User>{

    @Autowired
    UserService userService;

    @Autowired
    public PasswordEncoder passwordEncoder;

    public UserController(UserService userService) {
        super(userService);
    }

    @GetMapping("/username/{username}")
    public User getByUsername(@PathVariable String username) throws Exception {
        return userService.findByUsername(username);
    }

    @PutMapping("/{id}/password")
    public ResponseEntity<?> changePassword(@PathVariable Long id, @RequestBody PasswordChangeRequest request){
        try {
            User user = userService.findById(id);

            // Si la contrase;a del usuario no coincide con la guardada
            if (!passwordEncoder.matches(request.getOldPassword(), user.getPassword())){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Constraseña incorrecta");
            }

            user.setPassword(passwordEncoder.encode(request.getNewPassword()));
            userService.save(user);

            return ResponseEntity.ok("Contraseña actualizada");


        }catch(Exception e){
            throw new RuntimeException(e.getMessage());

        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchUser (@PathVariable  Long id, @RequestBody RequestPatchUser newUser) {
        try{
            User updatedUser = userService.patchUser(id, newUser);
            return ResponseEntity.ok(200);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error" + e.getMessage());
        }
    }

    @PutMapping("/{id}/password/admin")
    public ResponseEntity<?> changePasswordByAdmin(@PathVariable Long id, @RequestBody PasswordChangeRequest request) {

        try {
            User user = userService.findById(id);

            // Solo encripta y guarda la nueva contraseña
            user.setPassword(passwordEncoder.encode(request.getNewPassword()));
            userService.save(user);

            return ResponseEntity.ok("Contraseña actualizada por admin");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }


}
