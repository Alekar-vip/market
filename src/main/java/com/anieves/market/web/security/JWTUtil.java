package com.anieves.market.web.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {
    //clave
    private static final String KEY = "alejo006";

    /*
        Metodo para generar un token y retornarlos directamente
     */
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, KEY ).compact();
    }

    //Validar el JWT
    public boolean validateToken(String token, UserDetails userDetails){
        return userDetails.getUsername().equals(extractUsername(token)) && !isTokenExpired(token);
    }

    //Metodo para extraer el usuario
    public String extractUsername(String token){
        return getClaims(token).getSubject();
    }

    //Metodo que retorna un valor booleando validar que no haya expirado el JWT
    public boolean isTokenExpired(String token){
        return getClaims(token).getExpiration().before(new Date());
    }


    private Claims getClaims(String token){
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }
}
