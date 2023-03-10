package com.server.jwt.jwtsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.server.jwt.jwtsecurity.models.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
  Optional<User> findByUsername(String username);
  Boolean existsByUsername(String username);
  Boolean existsByEmail(String email);

  @Query("UPDATE User SET ip = ?1 WHERE username = ?2")
  @Modifying
  public void updateFailedAttempts(String ip, String username);
}
