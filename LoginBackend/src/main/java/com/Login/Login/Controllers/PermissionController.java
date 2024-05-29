package com.Login.Login.Controllers;

import com.Login.Login.Dtos.PermissionDto;
import com.Login.Login.Models.Permission;
import com.Login.Login.Services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @PostMapping("/createpermission")
    public ResponseEntity<String> createPermission(@RequestBody PermissionDto permissionDto){

        permissionService.createNewPermission(permissionDto);
        return ResponseEntity.status(HttpStatus.OK).body("permission created");
    }
}
