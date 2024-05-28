package com.Login.Login.Repositories;

import com.Login.Login.Models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPermission extends JpaRepository<Permission, Long> {
}
