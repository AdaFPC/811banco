package com.adafpc.letscode.banco.service;

import com.adafpc.letscode.banco.model.SaldoUserView;
import com.adafpc.letscode.banco.model.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TransacaoService {

    Page<Transacao> getAll(Pageable page, Integer userId, Integer contaId);

}
