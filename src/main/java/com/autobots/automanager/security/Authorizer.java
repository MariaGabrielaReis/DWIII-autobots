package com.autobots.automanager.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.autobots.automanager.security.jwt.Provider;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class Authorizer extends BasicAuthenticationFilter {
  private Provider jwtProvider;
  private UserDetailsService userDetailsService;
  private JWTAuthenticator jwtAuthenticator;

  public Authorizer(AuthenticationManager authenticationManager, Provider jwtProvider,
      UserDetailsService userDetailsService) {
    super(authenticationManager);
    this.userDetailsService = userDetailsService;
    this.jwtProvider = jwtProvider;
  }

  public String _getJwt(String header) {
    String[] parts = header.split(" ");
    return parts[1];
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    String header = request.getHeader("Authorization");

    if (header != null && header.startsWith("Bearer ")) {
      String jwt = _getJwt(header);
      jwtAuthenticator = new JWTAuthenticator(jwt, jwtProvider, userDetailsService);
      UsernamePasswordAuthenticationToken authentication = jwtAuthenticator.getAuthentication();
      if (authentication != null) {
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    }
    chain.doFilter(request, response);
  }
}
