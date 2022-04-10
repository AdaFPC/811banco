package com.adafpc.letscode.banco.service;

import com.adafpc.letscode.banco.dto.UserRequest;
import com.adafpc.letscode.banco.dto.UserResponse;
import com.adafpc.letscode.banco.model.SaldoUserView;
import com.adafpc.letscode.banco.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserService {
    Page<User> getAll(String nome, int page, int size);
    UserResponse create(UserRequest userRequest);
    User getById(Integer id);
    User update(UserRequest userRequest, Integer id);
    void delete(Integer id);
    List<SaldoUserView> getSaldoUser();
    List<UserResponse> findByCpf(@Param("cpf") String cpf);
}

