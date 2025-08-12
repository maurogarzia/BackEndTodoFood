package com.TodoFood.TodoFood.jwt;

import com.TodoFood.TodoFood.Services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();

        // Permitir acceso sin token a login y register
        if (path.equals("/todoFood/auth/login") || path.equals("/todoFood/auth/register")) {
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");

        try {
            // Verificar que el header Authorization esté presente y empiece con "Bearer "
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                String token = authHeader.substring(7);  // Extraer el token (sin "Bearer ")

                String username = jwtUtils.extractUSer(token);    // Extraer username desde token
                String roleFromToken = jwtUtils.extractRole(token);// Extraer rol desde token

                // Solo autenticar si no hay nadie autenticado en el contexto actual
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails userDetails = userService.loadUserByUsername(username); // Cargar detalles del usuario

                    // Validar que el token sea válido para este usuario (username, rol y expiración)
                    if (jwtUtils.validToken(token, userDetails)) {
                        // Crear el objeto de autenticación con detalles y authorities
                        UsernamePasswordAuthenticationToken auth =
                                new UsernamePasswordAuthenticationToken(
                                        userDetails,
                                        null,
                                        userDetails.getAuthorities()
                                );
                        auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                        // Setear la autenticación en el contexto de seguridad de Spring
                        SecurityContextHolder.getContext().setAuthentication(auth);
                    }
                }
            }
        } catch (Exception e) {
            // En caso de error (token inválido, expirado, etc) simplemente continuar sin autenticar
            System.out.println("Token inválido o error en JwtFilter: " + e.getMessage());
        }

        // Continuar con el siguiente filtro en la cadena
        filterChain.doFilter(request, response);
    }

}
