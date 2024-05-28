package com.Login.Login.Repositories;

import com.Login.Login.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRole extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleName(String roleName);
}
