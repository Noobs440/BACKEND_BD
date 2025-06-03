package com.example.gateway_bd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;


@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
        .route("notification-service",r->r.path("/api/documents/git ")
            .uri("http:.route(//localhost:8081"))

          .route("user-service",r->r.path("/api/auth")
            .and().method("POST")
            .and().readBody(User.class, s->true)
            .uri("http:.route(//localhost:8085"))   
          .route("user-service",r->r.path("/api/user/**")
            .and().method("GET")
            .and().readBody(User.class, s->true)
            .uri("http:.route(//localhost:8085"))   
          .route("user-service",r->r.path("/api/user/**")
            .and().method("POST")
            .and().readBody(User.class, s->true)
            .uri("http:.route(//localhost:8085"))   
          .route("user-service",r->r.path("/api/user/**")
            .and().method("PUT")
            .and().readBody(User.class, s->true)
            .uri("http:.route(//localhost:8085"))   
          .route("user-service",r->r.path("/api/user/**")
            .and().method("DELETE")
            .and().readBody(User.class, s->true)
            .uri("http:.route(//localhost:8085"))   


            
         .route("file-service",r->r.path("/service/**")
            .uri("http:.route(//localhost:8083"))    

         .route("academic-service",r->r.path("/service/**")
            .uri("http:.route(//localhost:8084"))    

        .build(); 
    }
}

    
