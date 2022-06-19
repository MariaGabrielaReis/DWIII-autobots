package com.autobots.automanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.autobots.automanager.adapters.UserDetailsServiceImplementation;
import com.autobots.automanager.security.Authorizer;
import com.autobots.automanager.security.CredentialAuthenticator;
import com.autobots.automanager.security.jwt.Provider;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsServiceImplementation userDetailsServiceImplementation;

  @Autowired
  private Provider jwtProvider = new Provider();

  private static final String[] publicRoutes = { "/", "/users/create", "/users/" };

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors().and().csrf().disable();

    http.authorizeHttpRequests().antMatchers(publicRoutes).permitAll().anyRequest().authenticated();

    http.addFilter(new CredentialAuthenticator(authenticationManager(), jwtProvider));
    http.addFilter(new Authorizer(authenticationManager(), jwtProvider, userDetailsServiceImplementation));

    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

  @Override
  protected void configure(AuthenticationManagerBuilder authenticator) throws Exception {
    authenticator.userDetailsService(userDetailsServiceImplementation).passwordEncoder(new BCryptPasswordEncoder());
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    UrlBasedCorsConfigurationSource font = new UrlBasedCorsConfigurationSource();
    font.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
    return font;
  }
}
