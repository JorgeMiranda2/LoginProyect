package com.Login.Login.Dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AccessResponseDto {
    private String token;
    private String tokenType = "Bearer ";
    private String username;
}
