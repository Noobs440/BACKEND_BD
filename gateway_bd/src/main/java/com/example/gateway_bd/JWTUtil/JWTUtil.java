package com.example.gateway_bd.JWTUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JWTUtil {

    @Value( "${jwt.secret}" )
    private String secret;
    
    public  Claims getAllClaims (String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private boolean isTokenExpired (String token) {
        return this.getAllClaims(token).getExpiration().before (new Date());
    }

    public boolean isInvalid (String token) {
        return this.isTokenExpired(token);
    }

}
