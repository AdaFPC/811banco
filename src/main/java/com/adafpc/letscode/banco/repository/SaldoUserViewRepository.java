package com.adafpc.letscode.banco.repository;

import com.adafpc.letscode.banco.model.SaldoUserView;
import org.springframework.stereotype.Repository;

@Repository
public interface SaldoUserViewRepository extends ReadOnlyRepository<SaldoUserView, String>{
}
