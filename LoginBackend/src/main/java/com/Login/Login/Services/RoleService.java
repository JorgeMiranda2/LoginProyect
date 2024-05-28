package com.Login.Login.Services;

import com.Login.Login.Models.Role;
import com.Login.Login.Repositories.IRole;
import com.Login.Login.Security.SecurityConstants;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


@Service
public class RoleService {

    @Autowired
    private IRole roleRepository;

    @Cacheable("roles")
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public List<String> getAllRoleNames() {
        return getAllRoles().stream().map(Role::getRoleName).collect(Collectors.toList());
    }
}
