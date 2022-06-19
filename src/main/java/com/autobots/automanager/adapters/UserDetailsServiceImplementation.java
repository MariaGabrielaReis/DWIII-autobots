package com.autobots.automanager.adapters;

import java.util.List;

import com.autobots.automanager.entity.User;
import com.autobots.automanager.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  private User getByLogin(String login) {
    List<User> users = userRepository.findAll();
    User userSelected = null;
    for (User user : users) {
      if (user.getCredential().getLogin().equals(login)) {
        userSelected = user;
        break;
      }
    }
    return userSelected;
  }

  @Override
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    User userSelected = this.getByLogin(login);
    if (userSelected == null) {
      throw new UsernameNotFoundException(login);
    }
    return new UserDetailsImplementation(userSelected);
  }
}