package br.com.liberato.fintech.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "conta")
public class Conta {

    @Id
    private String numero;

    @Column(name = "nome_titular")
    private String nomeTitular;

    @Column(name = "saldo")
    private Double saldo;
}
