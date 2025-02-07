package com.forniaia.demo.jwt.jwt;

import com.forniaia.demo.jwt.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Esta clase crea el jwt
 *
 * **/

@Service
public class JwtService {

    private static final String SECRET_KEY = "LK343FJASFDAS893W4UFOI5634576347fgsdfg34576345764256trg4256345AJDFLKVJADDS";

    public String getToken(UserDetails user) {
        return getToken(new HashMap<>(), user);
    }

    /**
     * Aquí se ponen los datos que va a llevar el payload del jwt
     *
     * **/
    private String getToken(Map<String, Object> extraClaims, UserDetails user) {
        extraClaims.put("role", ((User) user).getRole().name());  // Añadimos el role al token
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * Método que recoge el username del token
     * **/

    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        final String role = getRoleFromToken(token);  // Obtenemos el role desde el token
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token) && role != null);
    }

    private Claims getAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Date getExpiration(String token) {
        return getClaim(token, Claims::getExpiration);
    }

    /**
     * Método que obtiene el role del token
     **/
    public String getRoleFromToken(String token) {
        return getClaim(token, claims -> claims.get("role", String.class));  // Ahora obtenemos el role como String
    }

    private boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }
}
