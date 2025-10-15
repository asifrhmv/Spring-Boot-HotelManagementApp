package com.asif.hotel_reservation.util;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Collections;


@Component
public class JwtFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
final String authHeader=request.getHeader("Authorization");
if(authHeader!=null && authHeader.startsWith("Bearer ")){
    String token=authHeader.substring(7);
    String username= jwtUtil.extractUser(token);
    if(username!=null){
        UsernamePasswordAuthenticationToken auth=
                new UsernamePasswordAuthenticationToken(username,null, Collections.emptyList());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}
filterChain.doFilter(request,response);
    }
}
