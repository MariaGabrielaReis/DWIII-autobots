package com.autobots.automanager.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;

@Component
public class Provider {
  @Value("${jwt.secret}")
  private String signature;
  @Value("${jwt.expiration}")
  private Long duration;

  private Generator generator = new Generator(signature, duration);
  private Analyzer analyzer;
  private Validator validator = new Validator();

  public String provideJwt(String login) {
    return generator.generateJwt(login);
  }

  public boolean validateJwt(String jwt) {
    analyzer = new Analyzer(signature, jwt);
    return validator.validate(analyzer.getClaims());
  }

  public String getLogin(String jwt) {
    analyzer = new Analyzer(signature, jwt);
    Claims claims = analyzer.getClaims();
    return analyzer.getLogin(claims);
  }
}