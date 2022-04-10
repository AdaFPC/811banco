package com.adafpc.letscode.banco.controller;

import com.adafpc.letscode.banco.dto.ContaRequest;
import com.adafpc.letscode.banco.dto.ContaResponse;
import com.adafpc.letscode.banco.model.Conta;
import com.adafpc.letscode.banco.model.SaldoUserView;
import com.adafpc.letscode.banco.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios/{id}/conta")
public class ContaController {

    @Autowired
    ContaService contaService;



    @PostMapping
    public ContaResponse createAccount(
            @PathVariable Integer id,
            @RequestBody ContaRequest contaRequest) {
        return contaService.createAccount(id, contaRequest);
    }

    @GetMapping("/{contaId}")
    public Conta getById(@PathVariable Integer id, @PathVariable Integer contaId){
        return contaService.getById(contaId, id);
    }

    @PutMapping("/{contaId}")
    public Conta update(@PathVariable Integer id, @RequestBody ContaRequest contaRequest, @PathVariable Integer contaId){
        return contaService.update(contaRequest, contaId, id);
    }

    @DeleteMapping("/{contaId}")
    public void delete(@PathVariable Integer id,@PathVariable Integer contaId){
        contaService.delete(contaId, id);
    }



}