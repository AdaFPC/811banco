package com.adafpc.letscode.banco.controller;

import com.adafpc.letscode.banco.dto.ContaRequest;
import com.adafpc.letscode.banco.dto.ContaResponse;
import com.adafpc.letscode.banco.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContaController {

    @Autowired
    ContaService contaService;

    @PostMapping("/usuarios/{id}/conta")
    public ContaResponse createAccount(
            @PathVariable Integer id,
            @RequestBody ContaRequest contaRequest) {
        return contaService.createAccount(id, contaRequest);
    }

}