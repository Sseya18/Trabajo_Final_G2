package com.cobranza.autenticacion_microservices.seguridad;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SeguridadConfig {

    private static final String SECRET_KEY = "VGhpcy1pcy1hLXNlY3VyZS1zZWNyZXQta2V5LTEyMzQ1Ng==";

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public JwtDecoder jwtDecoder() {
        // Usa la clave secreta para configurar el decodificador JWT
        return NimbusJwtDecoder.withSecretKey(
            new javax.crypto.spec.SecretKeySpec(
                java.util.Base64.getDecoder().decode(SECRET_KEY),
                "HmacSHA256"
            )
        ).build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Deshabilita CSRF
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/registrar", "/auth/login").permitAll() // Permite acceso sin autenticación a estos endpoints
                .anyRequest().authenticated() // Requiere autenticación para cualquier otro endpoint
            )
            .oauth2ResourceServer(oauth2 -> oauth2.jwt());
        return http.build();
    }

}
