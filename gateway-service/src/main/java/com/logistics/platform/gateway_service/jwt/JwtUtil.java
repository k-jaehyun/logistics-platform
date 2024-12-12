package com.logistics.platform.gateway_service.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Jwts.SIG;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.SignatureException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";
    public static final String AUTHORIZATION_ROLE = "role";

    private final SecretKey secretKey;

    public JwtUtil(@Value("${service.jwt.secret-key}") String secretKey) {
        this.secretKey = new SecretKeySpec(
            Decoders.BASE64.decode(secretKey), SIG.HS256.key().build().getAlgorithm());
    }


    public String extractToken(ServerHttpRequest request) {
        String authHeader = request.getHeaders().getFirst(AUTHORIZATION_HEADER);
        if(authHeader != null && authHeader.startsWith(BEARER_PREFIX)) {
            return authHeader.substring(7);
        } else {
            return null;
        }
    }

    public Claims validateToken(String token) {

        try {
            return Jwts.parser()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
        }catch (ExpiredJwtException e) {
            throw new RuntimeException("만료된 토큰입니다", e);
        } catch (MalformedJwtException e) {
            throw new RuntimeException("잘못된 형식입니다", e);
        } catch (SignatureException e) {
            throw new RuntimeException("유효하지 않은 서명입니다", e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("유효하지 않은 토큰입니다", e);
        }

    }

    public String extractUsername(String token) {
        return validateToken(token).getSubject();
    }

    // 토큰에서 역할(role) 추출
    public String extractRole(String token) {
        return (String) validateToken(token).get(AUTHORIZATION_ROLE);
    }

}
