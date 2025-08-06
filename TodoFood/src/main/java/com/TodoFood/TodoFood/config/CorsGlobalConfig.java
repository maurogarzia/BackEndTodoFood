package com.TodoFood.TodoFood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsGlobalConfig {

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);  // permite cookies/autenticación cruzada
        config.setAllowedOrigins(Arrays.asList("http://localhost:5173"));  // tu frontend
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(Arrays.asList("*"));  // permitir todos los headers
        config.setExposedHeaders(Arrays.asList("Authorization")); // opcional: para leer Authorization en frontend

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  // esto es necesario
        source.registerCorsConfiguration("/**", config);  // acá registrás la config para todas las rutas

        return new CorsFilter(source);  // devolvés el filtro CORS
    }
}
