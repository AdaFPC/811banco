package com.adafpc.letscode.banco.service.impl;

import com.adafpc.letscode.banco.model.SaldoUserView;
import com.adafpc.letscode.banco.model.Transacao;
import com.adafpc.letscode.banco.repository.SaldoUserViewRepository;
import com.adafpc.letscode.banco.repository.TransacaoRepository;
import com.adafpc.letscode.banco.service.ContaService;
import com.adafpc.letscode.banco.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    @Autowired
    TransacaoRepository transacaoRepository;

    @Autowired
    ContaService contaService;



    @Override
    public Page<Transacao> getAll(Pageable page, Integer userId, Integer contaId) {
        contaService.getById(contaId, userId);

        return transacaoRepository.findAll(page);
    }



}
