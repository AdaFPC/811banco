package com.adafpc.letscode.banco.service;

import com.adafpc.letscode.banco.dto.ContaRequest;
import com.adafpc.letscode.banco.dto.ContaResponse;
import com.adafpc.letscode.banco.model.Conta;

public interface ContaService {

    ContaResponse createAccount(Integer id, ContaRequest contaRequest);

}
