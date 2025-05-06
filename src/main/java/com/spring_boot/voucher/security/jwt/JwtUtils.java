package com.spring_boot.voucher.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtils {
    @Value("${jwt.secret}")
    private String secretkey;

    @Value("${jwt.expiration}")
    private long jwtExpirationMs;

    private Key getSigningKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretkey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String email, Long Id){
        return Jwts.builder()
                .subject(email)
                .claim("Id", Id)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(getSigningKey())
                .compact();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(getSigningKey()).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e){
            return false;
        }
    }

    public String getEmailFromToken(String token){
        return getClaimFromToken(token, Claims::getSubject);
    }

    public String getIdFromToken(String token){
        return (String) getClaimFromToken(token, claims -> claims.get("Id"));
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T > claimsResolver){
        final Claims claims = Jwts.parser().setSigningKey(getSigningKey()).build()
                .parseClaimsJws(token).getBody();
        return claimsResolver.apply(claims);
    }
}
