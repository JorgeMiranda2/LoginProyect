package com.Login.Login.Services;

import com.Login.Login.Dtos.AddRoleToUserDto;
import com.Login.Login.Models.Role;
import com.Login.Login.Models.State;
import com.Login.Login.Models.User;
import com.Login.Login.Models.UserRole;
import com.Login.Login.Repositories.IRole;
import com.Login.Login.Repositories.IState;
import com.Login.Login.Repositories.IUser;
import com.Login.Login.Repositories.IUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserRoleService {
    private static final Logger logger = LoggerFactory.getLogger(UserRoleService.class);

    @Autowired
    private IUserRole userRoleRepository;

    @Autowired
    private IUser userRepository;

    @Autowired
    private IRole roleRepository;

    @Autowired
    private IState stateRepository;

    public UserRole addUserRole(AddRoleToUserDto addRoleToUserDto) {
        try {
            Optional<User> userOpt = userRepository.findById(addRoleToUserDto.getUser_id());
            Optional<Role> roleOpt = roleRepository.findById(addRoleToUserDto.getRole_id());
            Optional<State> stateOpt = stateRepository.findById(2L);

            if (userOpt.isPresent() && roleOpt.isPresent() && stateOpt.isPresent()) {
                UserRole userRole = userRoleRepository.save(
                        UserRole.builder()
                                .user(userOpt.get())
                                .role(roleOpt.get())
                                .state(stateOpt.get())
                                .build()
                );
                return userRole;
            } else {
                throw new IllegalArgumentException("User or Role not found");
            }
        } catch (Exception e) {
            logger.error("Error adding user role", e);
            throw new RuntimeException("Error adding user role", e);
        }
    }
}


