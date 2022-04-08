package com.adafpc.letscode.banco.repository;

import com.adafpc.letscode.banco.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
