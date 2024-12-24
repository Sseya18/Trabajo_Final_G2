package com.cobranza.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("gestion-deudores-route", r -> r.path("/deudores/**")
                        .uri("lb://gestiondeudores-microservices"))
                .route("gestion-clientes-route", r -> r.path("/clientes/**")
                        .uri("lb://gestionclientesmicroservicios"))
                .route("generacion-compromisopago-route", r -> r.path("/compromisopago/**")
                        .uri("lb://generacioncompromisopago-microservices"))
                .route("autenticacion-microservices-route", r -> r.path("/auth/**")
                        .uri("lb://autenticacion-microservices"))
                .build();
    }
}
