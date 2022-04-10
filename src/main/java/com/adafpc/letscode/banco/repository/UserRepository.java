package com.adafpc.letscode.banco.repository;

import com.adafpc.letscode.banco.dto.UserResponse;
import com.adafpc.letscode.banco.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select new com.adafpc.letscode.banco.dto.UserResponse(u.id, u.cpf, u.nome, u.dataCriacao, u.dataAtualizacao) from User u " +
            "where u.cpf = :cpf")
    List<UserResponse> findByCpf(@Param("cpf") String cpf);
}
