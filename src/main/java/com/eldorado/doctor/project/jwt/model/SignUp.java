package com.eldorado.doctor.project.jwt.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import java.util.Set;


@Getter
public class SignUp {

    @Setter
    private String name;

    @Email
    private String username;

    @Setter
    private String photo;

    @Setter
    private Set<String> roles;

    @Setter
    private String password;
}
