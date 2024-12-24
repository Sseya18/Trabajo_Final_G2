package com.cobranza.autenticacion_microservices.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SeguridadConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Deshabilita CSRF
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/registrar", "/auth/login").permitAll() // Permite acceso sin autenticación a estos endpoints
                .anyRequest().authenticated() // Requiere autenticación para cualquier otro endpoint
            );
        return http.build();
    }

}
