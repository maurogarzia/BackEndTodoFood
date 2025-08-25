package com.TodoFood.TodoFood.config;

import com.TodoFood.TodoFood.Services.UserService;
import com.TodoFood.TodoFood.jwt.JwtFilter;
import com.TodoFood.TodoFood.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    JwtFilter jwtFilter;

    @Autowired
    UserService userService;

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
        return http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> {})
                .cors(cors -> cors.configurationSource(corsConfigurationSource())).cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        // Permitir login y registro sin token
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .requestMatchers("/todoFood/auth/register").permitAll()
                        .requestMatchers("/todoFood/auth/login").permitAll()


                        // Permitir ver productos sin el token
                        .requestMatchers(HttpMethod.GET, "/todoFood/product/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/todoFood/promotion/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/todoFood/product-details/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/todoFood/promotion-details/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/todoFood/branches").permitAll()
                        .requestMatchers(HttpMethod.GET, "/todoFood/size").permitAll()

                        // Solo el admin puede cambiar la contrasenia
                        .requestMatchers(HttpMethod.PUT, "/todoFood/user/*/password/admin").hasRole("ADMIN")


                        // Todo lo demas requiere JWT
                        .anyRequest().authenticated()
                )
                .userDetailsService(userService)
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // En dev: solo frontend local
        configuration.setAllowedOrigins(List.of("http://localhost:5173"));
        // Si querés abrir a todos en dev, usá: List.of("*")

        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true); // si usás cookies o Authorization: Bearer

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
