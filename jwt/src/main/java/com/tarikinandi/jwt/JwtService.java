package com.tarikinandi.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {

    public static final String SECRET_KEY = "vOoY9HR+z3Rvtc0ODZ8WrKBzjoIJGFthst/Jhxlnf2Q=";

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claimsMap = new HashMap<>();

        if (userDetails.getAuthorities() != null && !userDetails.getAuthorities().isEmpty()) {
            claimsMap.put("role", userDetails.getAuthorities().iterator().next().getAuthority());
        }
        return Jwts.builder()
                    .setSubject(userDetails.getUsername())
                    .addClaims(claimsMap)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 4))
                    .signWith(getKey() , SignatureAlgorithm.HS256)
                    .compact();
    }

    public String getClaimsByKey(String token , String key){
        Claims claims = getClaims(token);
        return claims.get(key).toString();
    }

    public Claims getClaims(String token){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token).getBody();
        return claims;
    }


    public <T> T exportToken(String token, Function<Claims, T> claimsFunction) {
        Claims claims = getClaims(token);
        return claimsFunction.apply(claims);
    }

    public String getUsernameFromToken(String token) {
        return exportToken(token, Claims::getSubject);
    }

    public boolean isTokenExpired(String token) {
        Date expiration = exportToken(token, Claims::getExpiration);
        return expiration.before(new Date());
    }

    public Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
