package com.adafpc.letscode.banco.dto;

import com.adafpc.letscode.banco.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {
    private Integer id;
    private String cpf;
    private String nome;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public UserResponse(User usuario) {
        this.id = usuario.getId();
        this.cpf = usuario.getCpf();
        this.dataCriacao = usuario.getDataCriacao();
        this.nome = usuario.getNome();
        this.dataAtualizacao = usuario.getDataAtualizacao();
    }

    public static List<UserResponse> toResponse(List<User> users){
        return  users.stream().map(UserResponse::new).collect(Collectors.toList());
    }
}
