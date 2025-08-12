package com.TodoFood.TodoFood.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtUtils {

    @Value("${jwt.secret.key}")
    private String secretKeyEncoded;

    // Obtener la clave secreta para firmar/verificar JWT a partir del string base64
    private SecretKey getSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKeyEncoded);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Generar un token JWT con username y rol como claim
    public String tokenGenerate(UserDetails user) {
        // Extraer el rol del usuario (el primer authority sin el prefijo "ROLE_")
        String role = user.getAuthorities().stream()
                .findFirst()
                .map(auth -> auth.getAuthority().replace("ROLE_", ""))
                .orElse("");

        // Crear el JWT con subject, rol, fecha de emisión y expiración, y firmar con la clave secreta
        return Jwts.builder()
                .setSubject(user.getUsername())    // El username va en el subject
                .claim("role", role)               // Agregar el rol como claim personalizado
                .setIssuedAt(new Date())           // Fecha de emisión
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // Expira en 1 hora
                .signWith(getSecretKey(), SignatureAlgorithm.HS256) // Firmar con HMAC SHA256
                .compact();
    }

    // Extraer el username (subject) desde el token
    public String extractUSer(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSecretKey())    // Usar la clave secreta para verificar firma
                .build()
                .parseClaimsJws(token)            // Parsear el JWT y validar firma
                .getBody()
                .getSubject();                    // Obtener el subject (username)
    }

    // Extraer el rol desde el claim "role" del token
    public String extractRole(String token) {
        return (String) Jwts.parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("role");                     // Obtener el claim custom "role"
    }

    // Verificar si el token está expirado comparando con la fecha actual
    private boolean isExpired(String token) {
        Date exp = Jwts.parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();                 // Obtener fecha de expiración
        return exp.before(new Date());            // true si expirado
    }

    // Validar token: que el username coincida, el rol coincida y que no esté expirado
    public boolean validToken(String token, UserDetails user) {
        String usernameToken = extractUSer(token);    // Extraer username desde token
        String roleToken = extractRole(token);        // Extraer rol desde token

        // Extraer rol del userDetails para comparar
        String userRole = user.getAuthorities().stream()
                .findFirst()
                .map(auth -> auth.getAuthority().replace("ROLE_", ""))
                .orElse("");

        // Validar igualdad de username y rol, y que no esté expirado
        return user.getUsername().equals(usernameToken)
                && userRole.equals(roleToken)
                && !isExpired(token);
    }

}
