package com.Login.Login.Repositories;

import com.Login.Login.Models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRole extends JpaRepository<UserRole, Long> {
}
