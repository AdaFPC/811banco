package com.adafpc.letscode.banco.model;

import com.adafpc.letscode.banco.dto.ContaRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "conta")
@Entity
@Getter @Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "agencia")
    private Integer agencia;

    @Column(name = "data_criacao")
    @CreatedDate
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    @LastModifiedDate
    private LocalDateTime dataAtualizacao;

    @Column(name = "saldo")
    private BigDecimal saldo;

    @Column(name = "tipo_conta")
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Transacao> transacoes;

    public Conta(ContaRequest contaRequest) {
        this.agencia = contaRequest.getAgencia();
        this.numero = contaRequest.getNumero();
        this.tipoConta = contaRequest.getTipoConta();
    }
}
