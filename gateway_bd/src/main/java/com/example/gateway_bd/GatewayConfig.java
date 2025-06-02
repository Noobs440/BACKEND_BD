package com.example.gateway_bd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;


@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
        .route("notification-service",r->r.path("/api/documents/git ")
            .uri("http:.route(//localhost:8081"))

         .route("project-service",r->r.path("/service/**")
            .uri("http:.route(//localhost:8082"))   
            
         .route("file-service",r->r.path("/service/**")
            .uri("http:.route(//localhost:8083"))    

         .route("academic-service",r->r.path("/service/**")
            .uri("http:.route(//localhost:8084"))    

          .route("user-service",r->r.path("/service/**")
            .uri("http:.route(//localhost:8085"))   
          
        .build(); 
    }
}

    
