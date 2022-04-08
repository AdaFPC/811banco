package com.adafpc.letscode.banco.service.impl;

import com.adafpc.letscode.banco.dto.ContaRequest;
import com.adafpc.letscode.banco.dto.ContaResponse;
import com.adafpc.letscode.banco.model.Conta;
import com.adafpc.letscode.banco.model.User;
import com.adafpc.letscode.banco.repository.ContaRepository;
import com.adafpc.letscode.banco.service.ContaService;
import com.adafpc.letscode.banco.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    UserService userService;


    @Override
    public ContaResponse createAccount(Integer usuarioId, ContaRequest contaRequest) {

        User user = userService.getById(usuarioId);

        Conta conta = new Conta(contaRequest);
        conta.setUser(user);
        conta.setTipoConta(contaRequest.getTipoConta());
        conta.setSaldo(new BigDecimal(0.0));
        contaRepository.save(conta);
        return new ContaResponse(conta);


    }



}
