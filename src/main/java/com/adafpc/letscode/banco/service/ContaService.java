package com.adafpc.letscode.banco.service;

import com.adafpc.letscode.banco.dto.ContaRequest;
import com.adafpc.letscode.banco.dto.ContaResponse;
import com.adafpc.letscode.banco.model.Conta;
import com.adafpc.letscode.banco.model.SaldoUserView;

import java.util.List;

public interface ContaService {

    ContaResponse createAccount(Integer id, ContaRequest contaRequest);
    Conta getById(Integer id, Integer userId);
    Conta update(ContaRequest contaRequest, Integer id, Integer userId);
    void delete(Integer id, Integer userId);


}
