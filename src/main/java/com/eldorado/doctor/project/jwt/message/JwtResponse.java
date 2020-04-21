package com.eldorado.doctor.project.jwt.message;


import lombok.Getter;
import lombok.Setter;

@Getter
public class JwtResponse {

    @Setter
    private String accessToken;

    private String tokenType = "Bearer";

    public JwtResponse(){}

    public JwtResponse(String token){
        this.accessToken = token;
    }
}
