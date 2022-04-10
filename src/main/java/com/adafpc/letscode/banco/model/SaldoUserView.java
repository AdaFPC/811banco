package com.adafpc.letscode.banco.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Immutable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaldoUserView {

  private String nome;

  @Id
  private String cpf;

  private BigDecimal saldo;


}
