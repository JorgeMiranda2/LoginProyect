package com.Login.Login.Dtos;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LoginDto {
    private String identifier;
    private String password;
}
