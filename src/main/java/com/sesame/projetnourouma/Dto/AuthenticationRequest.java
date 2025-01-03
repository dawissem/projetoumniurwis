package com.sesame.projetnourouma.Dto;


import lombok.Data;

@Data
public class AuthenticationRequest {
    private String login;
    private String password;
}
