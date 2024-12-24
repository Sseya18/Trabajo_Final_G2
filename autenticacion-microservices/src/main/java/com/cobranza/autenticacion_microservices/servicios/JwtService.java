package com.cobranza.autenticacion_microservices.servicios;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET_KEY = "VGhpcy1pcy1hLXNlY3VyZS1zZWNyZXQta2V5LTEyMzQ1Ng==";
    private static final long EXPIRATION_TIME = 3600000; // 1 hora

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(
                    new SecretKeySpec(
                        Base64.getDecoder().decode(SECRET_KEY), 
                        SignatureAlgorithm.HS256.getJcaName()
                    )
                )
                .compact();
    }
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Base64.getDecoder().decode(SECRET_KEY))
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject(); // Retorna el sujeto (username)
    }
    
}
