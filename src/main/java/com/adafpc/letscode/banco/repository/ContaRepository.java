package com.adafpc.letscode.banco.repository;

import com.adafpc.letscode.banco.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

    Optional<Conta>findByIdAndUserId(Integer contaId, Integer userId);

}
