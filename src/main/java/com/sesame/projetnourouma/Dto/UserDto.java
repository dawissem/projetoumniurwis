package com.sesame.projetnourouma.Dto;

import lombok.Data;

@Data
public class UserDto {
    private int id;

    private String name;
    private String prenom;
    private String cin;
    private String login;
    private String password;
}
