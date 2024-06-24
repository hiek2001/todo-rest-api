package com.example.demo.config.jwt;

import java.time.Duration;
import java.util.Base64;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private long tokenValidTime = Duration.ofDays(1).toMillis(); // 1일

    private final UserDetailsService memberDetailsService;
    
    @Value("${spring.jwt.secret-key}")
    private String secretKey;
    
//    @Value("${spring.jwt.password}")
//    private String secretKey;
    
    //==토큰 생성 메소드==//
    public String createToken(String subject) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + tokenValidTime); // 만료기간 1일

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE) // (1)
                .setIssuer("test") // 토큰발급자(iss)
                .setIssuedAt(now) // 발급시간(iat)
                .setExpiration(expiration) // 만료시간(exp)
                .setSubject(subject) //  토큰 제목(subject)
                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(secretKey.getBytes())) // 알고리즘, 시크릿 키
                .compact();
    }

    //==Jwt 토큰의 유효성 체크 메소드==//
    public Claims parseJwtToken(String token) {
        token = BearerRemove(token); // Bearer 제거
        return Jwts.parser()
                .setSigningKey(Base64.getEncoder().encodeToString(secretKey.getBytes()))
                .parseClaimsJws(token)
                .getBody();
    }
    
    //==토큰 앞 부분('Bearer') 제거 메소드==//
    private String BearerRemove(String token) {
        return token.substring("Bearer ".length());
    }
    
//    @PostConstruct
//    protected void init() {
//        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
//    }
//
//    // 토큰 생성
//	public String createToken(String id) {
//        Claims claims = Jwts.claims().setSubject(id);
//        Date now = new Date();
//
//        String token = Jwts.builder()
//                .setClaims(claims)
//                .setIssuedAt(now)	// 발급시간
//                .setExpiration(new Date(now.getTime() + tokenValidTime)) 	// 만료 시간
//                .signWith(SignatureAlgorithm.HS256, secretKey) // 알고리즘, 시크릿 키
//                .compact();
//        return token;
//    }
//
//    // 토큰에서 인증 객체 얻기
//    public Authentication getAuthentication(String token) {
//        UserDetails userDetails = memberDetailsService.loadUserByUsername(getMemberId(token));
//        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
//    }
//
//	public String getMemberId(String token) {
//        try {
//            return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
//        } catch(ExpiredJwtException e) {
//            return e.getClaims().getSubject();
//        }
//    }
//
//    public String resolveToken(HttpServletRequest req) {
//        return req.getHeader("X-AUTH-TOKEN");
//    }
//
//    // 토큰 만료 확인
//    public boolean validateTokenExceptExpiration(String token) {
//        try {
//            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
//            return !claims.getBody().getExpiration().before(new Date());
//        } catch(Exception e) {
//            return false;
//        }
//    }
}
