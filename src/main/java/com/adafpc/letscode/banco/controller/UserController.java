package com.adafpc.letscode.banco.controller;

import com.adafpc.letscode.banco.dto.UserRequest;
import com.adafpc.letscode.banco.dto.UserResponse;
import com.adafpc.letscode.banco.model.SaldoUserView;
import com.adafpc.letscode.banco.model.User;
import com.adafpc.letscode.banco.repository.UserRepository;
import com.adafpc.letscode.banco.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public Page<User> getAll(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "3") int size
    ) {
        return userService.getAll(nome, page, size);
    }
    @PostMapping
    public UserResponse create(@RequestBody UserRequest userRequest) {
        return userService.create(userRequest);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Integer id, @RequestBody UserRequest userRequest) {
        return userService.update(userRequest, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }

    @GetMapping("/saldo")
    public List<SaldoUserView> getSaldoUser(){
        return userService.getSaldoUser();
    }

    @GetMapping("/cpf")
    public List<UserResponse> findByCpf(@RequestParam String cpf) {
        return userService.findByCpf(cpf);
    }
}

