package com.adafpc.letscode.banco.repository;

import com.adafpc.letscode.banco.model.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TransacaoRepository extends PagingAndSortingRepository<Transacao, Integer> {

}
