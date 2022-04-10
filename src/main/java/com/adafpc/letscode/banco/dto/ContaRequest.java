package com.adafpc.letscode.banco.dto;

import com.adafpc.letscode.banco.model.TipoConta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContaRequest {
    private Integer agencia;
    private Integer numero;
    private TipoConta tipoConta;
    private BigDecimal saldo;
}
