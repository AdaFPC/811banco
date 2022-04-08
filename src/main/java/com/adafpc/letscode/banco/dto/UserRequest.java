package com.adafpc.letscode.banco.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserRequest {
    private String cpf;
    private String nome;
    private String senha;
    private String login;
}
