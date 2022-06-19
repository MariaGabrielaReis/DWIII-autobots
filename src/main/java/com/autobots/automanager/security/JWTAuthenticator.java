package com.autobots.automanager.security;

import com.autobots.automanager.security.jwt.Provider;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class JWTAuthenticator {
  private String jwt;
  private Provider jwtProvider;
  private UserDetailsService userDetailsService;

  public JWTAuthenticator(String jwt, Provider jwtProvider, UserDetailsService userDetailsService) {
    this.jwt = jwt;
    this.jwtProvider = jwtProvider;
    this.userDetailsService = userDetailsService;
  }

  public UsernamePasswordAuthenticationToken getAuthentication() {
    if (jwtProvider.validateJwt(jwt)) {
      String login = jwtProvider.getLogin(jwt);
      UserDetails user = userDetailsService.loadUserByUsername(login);
      return new UsernamePasswordAuthenticationToken(user, user.getPassword(),
          user.getAuthorities());
    }
    return null;
  }
}
