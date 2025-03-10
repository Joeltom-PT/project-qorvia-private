package com.qorvia.apigateway.config.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("account-service", r -> r.path("/account/**","/account-service/api/docs")
                        .uri("http://localhost:8880"))
                .route("blog-feedback-service", r -> r.path("/reviews/**","/report/**","/blog-feedback-service/api/docs")
                        .uri("http://localhost:8881"))
                .route("communication-service", r -> r.path("/communication/**","/communication-service/api/docs")
                        .uri("http://localhost:8882"))
                .route("event-management-service", r -> r.path("/event/**","/event-management-service/api/docs")
                        .uri("http://localhost:8883"))
                .route("notification-service", r -> r.path("/notification/**","/notification-service/api/docs")
                        .uri("http://localhost:8884"))
                .route("payment-service", r -> r.path("/payment/**","/payout-policy/**","/payment-service/api/docs")
                        .uri("http://localhost:8885"))
                .build();
    }
}
