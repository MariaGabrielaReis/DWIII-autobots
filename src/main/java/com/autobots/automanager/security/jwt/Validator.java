package com.autobots.automanager.security.jwt;

import java.util.Date;

import io.jsonwebtoken.Claims;

class Validator {
  public boolean validate(Claims claims) {
    if (claims != null) {
      String login = claims.getSubject();
      Date expirationDate = claims.getExpiration();
      Date now = new Date(System.currentTimeMillis());
      if (login != null && expirationDate != null && now.before(expirationDate)) {
        return true;
      }
    }
    return false;
  }
}