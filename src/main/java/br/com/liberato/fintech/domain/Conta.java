package br.com.liberato.fintech.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "conta")
public class Conta {

    @Id
    private String numero;

    @Column(name = "nome_titular")
    String nomeTitular;

    @Column(name = "saldo")
    private Double saldo;
}
