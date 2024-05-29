package com.Login.Login.Dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AddRoleToUserDto {
    private Long user_id;
    private Long role_id;
}
