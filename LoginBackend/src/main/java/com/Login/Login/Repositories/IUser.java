package com.Login.Login.Repositories;

import com.Login.Login.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUser extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);
}
