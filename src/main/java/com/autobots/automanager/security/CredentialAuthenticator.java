package com.autobots.automanager.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.autobots.automanager.entity.Credential;
import com.autobots.automanager.security.jwt.Provider;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CredentialAuthenticator extends UsernamePasswordAuthenticationFilter {

  private AuthenticationManager authenticationManager;
  private Provider jwtProvider;

  public CredentialAuthenticator(AuthenticationManager authenticationManager, Provider jwtProvider) {
    this.authenticationManager = authenticationManager;
    this.jwtProvider = jwtProvider;
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
      throws AuthenticationException {
    Credential credential = null;
    try {
      credential = new ObjectMapper().readValue(request.getInputStream(), Credential.class);
    } catch (IOException exception) {
      credential = new Credential();
      credential.setLogin("");
      credential.setPassword("");
    }
    UsernamePasswordAuthenticationToken authenticationData = new UsernamePasswordAuthenticationToken(
        credential.getLogin(), credential.getPassword(), new ArrayList<>());
    Authentication authentication = authenticationManager.authenticate(authenticationData);
    return authentication;
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
      Authentication authentication) throws IOException, ServletException {
    UserDetails user = (UserDetails) authentication.getPrincipal();
    String login = user.getUsername();
    String jwt = jwtProvider.provideJwt(login);
    response.addHeader("Authorization", "Bearer " + jwt);
  }
}
