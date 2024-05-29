package com.Login.Login.Controllers;

import com.Login.Login.Dtos.AddRoleToUserDto;
import com.Login.Login.Models.UserRole;
import com.Login.Login.Services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RoleController {
@Autowired
private UserRoleService userRoleService;

    @PostMapping("/addroletouser")
    public ResponseEntity<String> addRoleToUser(@RequestBody AddRoleToUserDto addRoleToUserDto){

        UserRole userRole = userRoleService.addUserRole(addRoleToUserDto);
    return ResponseEntity.status(HttpStatus.OK).body("role added successfully");
    }


}
