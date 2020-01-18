package com.taskMannagerTool.tasktoolservice.jwt;

import com.taskMannagerTool.tasktoolservice.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Component
@RequiredArgsConstructor
@Data
public class JwtToken implements Serializable{

    @Value("${jwt.token.secret}")
    private String secret;

    private static final long serialVersionUID = -2550185165626007488L;

    public static final long JWT_TOKEN_VALIDITY = 5*60*60;


    public String getUsernameFromToke(String token){
        return getClaimFromToken(token,Claims::getSubject);
    }

    public Date getExpirationDateFromToke(String token){

        return getClaimFromToken(token,Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims,T> claimsResolver){
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    public Claims getAllClaimsFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private boolean isTokenExpired(String token){

        final Date expiration = getExpirationDateFromToke(token);

        return expiration.before(new Date());

    }

    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();

        return doGenerateToken(claims,userDetails.getUsername());

    }

    public String doGenerateToken(Map<String, Object> claims,String subject){
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();

    }

    public Boolean validateToken(String token, UserDetails userDetails) {

        final String username = getUsernameFromToke(token);

        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));

    }


}
