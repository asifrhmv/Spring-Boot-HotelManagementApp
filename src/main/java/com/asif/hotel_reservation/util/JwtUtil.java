package com.asif.hotel_reservation.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Data
@Component
public class JwtUtil {
    private final String SECRET_KEY="mysecretkeymysecretkeymysecretkey123";

private Key getSignInKey(){
    return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
}

public String generateToken(String username){
    return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
            .signWith(getSignInKey(), SignatureAlgorithm.ES256)
            .compact();
}

public String extractUser(String token){
    return Jwts.parser()
            .setSigningKey(getSignInKey())
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
}
}
