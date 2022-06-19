package com.autobots.automanager.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

class Analyzer {
  private String signature;
  private String jwt;

  public Analyzer(String signature, String jwt) {
    this.signature = signature;
    this.jwt = jwt;
  }

  public Claims getClaims() {
    try {
      return Jwts.parser().setSigningKey(signature.getBytes()).parseClaimsJws(jwt).getBody();
    } catch (Exception e) {
      return null;
    }
  }

  public String getLogin(Claims claims) {
    if (claims != null) {
      return claims.getSubject();
    }
    return null;
  }
}