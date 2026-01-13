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
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        // 1️⃣ Ignorar OPTIONS
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            filterChain.doFilter(request, response);
            return;
        }

        String path = request.getRequestURI();

        // 2️⃣ Login y register sin token
        if (path.equals("/todoFood/auth/login") ||
                path.equals("/todoFood/auth/register")) {
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");

        // 3️⃣ Header inválido
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7).trim();

        // 4️⃣ Token vacío (ESTE ERA TU BUG)
        if (token.isEmpty()) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            String username = jwtUtils.extractUSer(token);

            if (username != null &&
                    SecurityContextHolder.getContext().getAuthentication() == null) {

                UserDetails userDetails =
                        userService.loadUserByUsername(username);

                if (jwtUtils.validToken(token, userDetails)) {
                    UsernamePasswordAuthenticationToken auth =
                            new UsernamePasswordAuthenticationToken(
                                    userDetails,
                                    null,
                                    userDetails.getAuthorities()
                            );

                    auth.setDetails(
                            new WebAuthenticationDetailsSource()
                                    .buildDetails(request)
                    );

                    SecurityContextHolder.getContext()
                            .setAuthentication(auth);
                }
            }

        } catch (Exception e) {
            System.out.println(
                    "Token inválido o error en JwtFilter: " + e.getMessage()
            );
        }

        filterChain.doFilter(request, response);
    }

}
