package com.adafpc.letscode.banco.service.impl;

import com.adafpc.letscode.banco.dto.ContaRequest;
import com.adafpc.letscode.banco.dto.ContaResponse;
import com.adafpc.letscode.banco.model.Conta;
import com.adafpc.letscode.banco.model.SaldoUserView;
import com.adafpc.letscode.banco.model.User;
import com.adafpc.letscode.banco.repository.ContaRepository;
import com.adafpc.letscode.banco.repository.SaldoUserViewRepository;
import com.adafpc.letscode.banco.service.ContaService;
import com.adafpc.letscode.banco.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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
        conta.setSaldo(contaRequest.getSaldo());
        contaRepository.save(conta);
        return new ContaResponse(conta);
    }

    @Override
    public Conta getById(Integer id, Integer userId){

        return contaRepository.findByIdAndUserId(id,userId).orElseThrow();
    }

    @Override
    public Conta update(ContaRequest contaRequest, Integer id, Integer userId){
        Conta conta = getById(id, userId);

        conta.setSaldo(contaRequest.getSaldo());

        return contaRepository.save(conta);
    }

    @Override
    public void delete(Integer id, Integer userId){
        Conta conta = getById(id, userId);
        contaRepository.delete(conta);
    }





}
