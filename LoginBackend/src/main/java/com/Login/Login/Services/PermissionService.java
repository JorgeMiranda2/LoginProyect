package com.Login.Login.Services;

import com.Login.Login.Models.Permission;

import com.Login.Login.Repositories.IPermission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PermissionService {

    @Autowired
    private IPermission permissionRepository;


    @Cacheable("permissions")
    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }
}
