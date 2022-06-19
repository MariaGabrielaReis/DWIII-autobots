package com.autobots.automanager.repository;

import java.util.List;

import com.autobots.automanager.entity.User;
import com.autobots.automanager.model.enums.UserRole;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  List<User> findByRole(UserRole role);
}