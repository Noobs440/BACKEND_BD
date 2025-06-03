package com.example.gateway_bd.filtres;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouteValidation {
    public static final List<String> unprotectedURLs = List.of(
        "/api/auth/register",
        "/api/auth/login"
        );

    public Predicate <ServerHttpRequest> isSecured = request -> unprotectedURLs.stream().noneMatch(uri -> request.getURI().getPath().contains(uri));
    
}                               
