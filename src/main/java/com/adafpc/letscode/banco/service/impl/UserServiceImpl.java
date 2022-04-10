package com.adafpc.letscode.banco.service.impl;

import com.adafpc.letscode.banco.dto.UserRequest;
import com.adafpc.letscode.banco.dto.UserResponse;
import com.adafpc.letscode.banco.model.SaldoUserView;
import com.adafpc.letscode.banco.model.User;
import com.adafpc.letscode.banco.repository.SaldoUserViewRepository;
import com.adafpc.letscode.banco.repository.UserRepository;
import com.adafpc.letscode.banco.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SaldoUserViewRepository saldoUserViewRepository;

    @Override
    public Page<User> getAll(String nome, int page, int size) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.DESC,
                "nome"
        );

        return userRepository.findAll(pageRequest);
    }


    @Override
    public UserResponse create(UserRequest userRequest) {

        User user = new User(userRequest);
        user = userRepository.save(user);

        return new UserResponse(user);
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User update(UserRequest userRequest, Integer id) {
        User user = userRepository.findById(id).orElseThrow();

        user.setNome(userRequest.getNome());
        user.setCpf(userRequest.getCpf());
        user.setSenha(userRequest.getSenha());

        return userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        var user = userRepository.findById(id).orElseThrow();

        userRepository.delete(user);
    }

    public List<SaldoUserView> getSaldoUser(){
        return saldoUserViewRepository.findAll();

    }

    @Override
    public List<UserResponse> findByCpf(String cpf) {
        return userRepository.findByCpf(cpf);
    }
}