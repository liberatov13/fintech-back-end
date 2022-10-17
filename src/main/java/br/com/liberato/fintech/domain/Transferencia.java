package br.com.liberato.fintech.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "transferencia")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idTransferencia;

    @ManyToOne
    @JoinColumn(name = "conta_origem")
    private Conta contaOrigem;

    @ManyToOne
    @JoinColumn(name = "conta_destino")
    private Conta contaDestino;

    @Column(name = "valor")
    private Double valor;

    @Column
    private Double taxa;

    @Column(name = "agendamento")
    private LocalDate dataAgendada;
}
