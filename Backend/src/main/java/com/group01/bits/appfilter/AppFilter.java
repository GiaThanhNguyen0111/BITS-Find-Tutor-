package com.group01.bits.appfilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@EqualsAndHashCode(callSuper = true)
@Data
@Component
@Slf4j
public class AppFilter extends OncePerRequestFilter {

    private final JwtAdapter jwtAdapter;

    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String jwtToken;
        final String username;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        jwtToken = authHeader.substring(7);
        username = jwtAdapter.extractUsername(jwtToken);
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetail = this.userDetailsService.loadUserByUsername(username);
            if (jwtAdapter.isTokenValid(jwtToken, userDetail)) {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetail,
                        null,
                        null
                );
                log.info(authenticationToken.toString());
                authenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Service
    public static class JwtAdapter {


        @Value("${app.jwt.encrypt.secret}")
        private String STRING_SECRET_KEY;

        public String extractUsername(String jwtToken) {
            return extractClaim(jwtToken, Claims::getSubject);
        }

        public String extraFamilyId(String jwtToken) {
            return extractClaim(jwtToken, Claims::getId);
        }
        public String generateToken(UserDetails userDetails, Long idFamily) {
            return generateToken(new HashMap<>(), userDetails, idFamily);
        }


        public <T> T extractClaim(String jwtToken, Function<Claims, T> claimsResolver) {
            final Claims claims = extractClaims(jwtToken);
            return claimsResolver.apply(claims);
        }

        public String generateToken(
                Map<String, String> extraClaims,
                UserDetails userDetails,
                Long idFamily
        ) {
            return Jwts
                    .builder()
                    .setId(idFamily.toString())
                    .setClaims(extraClaims)
                    .setSubject(userDetails.getUsername())
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10 * 10))
                    .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                    .compact();
        }



        //TODO: add idFamily vao jwtToken khi childrenAccount register hoac login -> sua hoac them trong doInternalFilter

        //TODO: add generate refreshToken
        private Claims extractClaims(String jwtToken) {
            return Jwts
                    .parserBuilder()
                    .setSigningKey(getSignInKey())
                    .build()
                    .parseClaimsJws(jwtToken)
                    .getBody();
        }

        private Key getSignInKey() {
            byte[] keyBytes = Decoders.BASE64.decode(STRING_SECRET_KEY);
            return Keys.hmacShaKeyFor(keyBytes);
        }

        private boolean isTokenValid(String jwtToken, UserDetails userDetails) {
            final String username = extractUsername(jwtToken);
            return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwtToken));
        }

        private boolean isTokenExpired(String token) {
            return extractExpiration(token).before(new Date());
        }

        private Date extractExpiration(String token) {
            return extractClaim(token, Claims::getExpiration);
        }
    }
}
