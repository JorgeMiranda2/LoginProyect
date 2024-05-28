package com.Login.Login.Controllers;


import com.Login.Login.Dtos.AccountDto;
import com.Login.Login.Dtos.LoginDto;
import com.Login.Login.Models.Person;
import com.Login.Login.Models.User;
import com.Login.Login.Repositories.IPerson;
import com.Login.Login.Repositories.IRole;
import com.Login.Login.Repositories.IUser;
import com.Login.Login.Security.JwtAuthenticationProvider;

import com.Login.Login.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.HashMap;
import java.util.Optional;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private IUser userRepository;
    @Autowired
    private IPerson personRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IRole roleRepository;
    @Autowired
    private JwtAuthenticationProvider jwtAuthenticationProvider;


    @PostMapping("/createaccount")
    public ResponseEntity<String> createAccount(@RequestBody AccountDto accountDto) {
        if(userRepository.existsByUsername(accountDto.getUsername())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user already  exists ");
        }

        try {
            HashMap<String, Object> registeredEntities = userService.registerUserAndPerson(accountDto, "USER");
            System.out.println("hashmap: " + registeredEntities.get("user"));
            User registeredUser = (User) registeredEntities.get("user");


            URI location = new URI("/api/users/" + registeredUser.getId());
            return ResponseEntity.created(location).body("Account created successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating account: " + e.getMessage());
        }
    }

    @PostMapping("/createaccountadmin")
    public ResponseEntity<String> createAccountadmin(@RequestBody AccountDto accountDto) {
        if(userRepository.existsByUsername(accountDto.getUsername())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user already  exists ");
        }

        try {
            HashMap<String, Object> registeredEntities = userService.registerUserAndPerson(accountDto, "ADMIN");
            System.out.println("hashmap: " + registeredEntities.get("user"));
            User registeredUser = (User) registeredEntities.get("user");


            URI location = new URI("/api/users/" + registeredUser.getId());
            return ResponseEntity.created(location).body("Account created successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating account: " + e.getMessage());
        }
    }
    @PostMapping("/login")
    public ResponseEntity<String> signIn(@RequestBody LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getIdentifier(), loginDto.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtAuthenticationProvider.createToken(authentication);
        return ResponseEntity.status(HttpStatus.OK).body(token);

        /*
        try {
            User user = userRepository.findByUsername(loginDto.getIdentifier())
                    .orElseGet(() -> personRepository.findByEmail(loginDto.getIdentifier())
                            .map(Person::getUser)
                            .orElseThrow(() -> new UsernameNotFoundException("User not found with identifier: " + loginDto.getIdentifier()))
                    );

            if(!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())){
                throw new Exception("No password match");
            }

            return null;
           // return ResponseEntity.created(location).body("Account created successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating account: " + e.getMessage());
        }
        */
    }

}
