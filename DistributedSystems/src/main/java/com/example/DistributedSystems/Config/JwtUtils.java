package com.example.DistributedSystems.Config;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;

import java.util.Date;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("123esef")
    private String jwtSecret;

    @Value("86400000")
    private int jwtExpirationMs;

    public String generateJwtToken(Authentication authentication){
        System.out.println("1");

        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();

        System.out.println("2");
        System.out.println(userPrincipal.getUsername());
        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserNameFromJwtToken(String token){
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) throws SignatureException{
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        }catch (MalformedJwtException e){
            logger.error("token {}", authToken);
            logger.error("Invalid Jwt Token: {}", e.getMessage());
        }catch (ExpiredJwtException e){
            logger.error("JWT Token is expired: {}", e.getMessage());
        }catch (UnsupportedJwtException e){
            logger.error("JWT Token in unsupported: {}", e.getMessage());
        }catch (IllegalArgumentException e){
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
}
