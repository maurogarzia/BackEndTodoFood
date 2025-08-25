package com.TodoFood.TodoFood.Services;

import com.TodoFood.TodoFood.Entities.User;
import com.TodoFood.TodoFood.Repositories.UserRepository;
import com.TodoFood.TodoFood.dtos.RequestPatchUser;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService extends BaseService<User> implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    public UserService(JpaRepository<User, Long> baseRepository) {
        super(baseRepository);
    }

    public User findByUsername(String username) throws Exception {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new Exception("No se encontró el usuario con ese nombre"));
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        // Asigno correctamente los roles
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().name())); // ROLE_ADMIN o ROLE_CUSTOMER

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), authorities
        );
    }

    // Patch para modificar los datos del usuario
    @Transactional
    public User patchUser (Long id, RequestPatchUser newUser) throws Exception {
        try{
            User existing = baseRepository.findById(id)
                    .orElseThrow(() -> new Exception("No se encontro el usuario")); // Si no encuentra al usuario por id


            if (newUser.getName() != null) existing.setName(newUser.getName());
            if (newUser.getLastname() != null) existing.setLastname(newUser.getLastname());
            if (newUser.getEmail() != null) existing.setEmail(newUser.getEmail());
            if (newUser.getPhone() != null) existing.setPhone(newUser.getPhone());
            if (newUser.getRole() != null) existing.setRole(newUser.getRole());
            if (newUser.getAddress() != null) {
                existing.setAddress(newUser.getAddress());
            } else {
                existing.setAddress(null);
            }
            if (newUser.getUsername() != null) existing.setUsername(newUser.getUsername());
            return baseRepository.save(existing); // Guardo la entidad

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
