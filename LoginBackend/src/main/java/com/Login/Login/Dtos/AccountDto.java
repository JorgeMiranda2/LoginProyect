package com.Login.Login.Dtos;

import com.Login.Login.Models.Person;
import com.Login.Login.Models.State;
import com.Login.Login.Models.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class AccountDto {

    //Person

    private String name;

    private String email;

    private String phone;

    private Date birthdate;

    private String identification;

    private String typeIdentification;

    //User

    private String username;

    private String password;


}
