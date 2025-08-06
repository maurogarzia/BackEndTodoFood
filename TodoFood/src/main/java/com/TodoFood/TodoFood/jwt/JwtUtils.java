package com.TodoFood.TodoFood.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtils {

    @Value("${jwt.secret.key}")
    private String secretKeyEncoded;

    // Método para obtener la clave secreta como SecretKey
    private SecretKey getSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKeyEncoded);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Generador de token
    public String tokenGenerate(UserDetails user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 1 hora
                .signWith(getSecretKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Extraer usuario
    public String extractUSer(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Verificar expiración
    private boolean isExpired(String token) {
        Date exp = Jwts.parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return exp.before(new Date());
    }

    // Validar token
    public boolean validToken(String token, UserDetails user) {
        String userToken = extractUSer(token);
        return user.getUsername().equals(userToken) && !isExpired(token);
    }
}
