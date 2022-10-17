package br.com.liberato.fintech.repository;

import br.com.liberato.fintech.domain.Conta;
import br.com.liberato.fintech.domain.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
    List<Transferencia> findByContaOrigem(Conta conta);
}
