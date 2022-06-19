package com.autobots.automanager.security.jwt;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

class Generator {
  private String signature;
  private Date expiration;

  public Generator(String signature, long duration) {
    this.signature = signature;
    this.expiration = new Date(System.currentTimeMillis() + duration);
  }

  public String generateJwt(String login) {
    String jwt = Jwts.builder().setSubject(login).setExpiration(this.expiration)
        .signWith(SignatureAlgorithm.HS512, this.signature.getBytes()).compact();
    return jwt;
  }
}
