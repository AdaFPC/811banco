package com.adafpc.letscode.banco.controller;

import com.adafpc.letscode.banco.model.SaldoUserView;
import com.adafpc.letscode.banco.model.Transacao;
import com.adafpc.letscode.banco.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios/{userId}/conta/{contaId}/transacoes")
public class TransacaoController {

    @Autowired
    TransacaoService transacaoService;

    @GetMapping
    public Page<Transacao>getAll(Pageable page,
                                 @PathVariable Integer userId,
                                 @PathVariable Integer contaId){
        return transacaoService.getAll(page, userId, contaId);
    }


}
