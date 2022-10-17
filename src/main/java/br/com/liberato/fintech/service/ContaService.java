package br.com.liberato.fintech.service;

import br.com.liberato.fintech.domain.Conta;
import br.com.liberato.fintech.domain.Transferencia;
import br.com.liberato.fintech.exception.ContaInexistenteException;
import br.com.liberato.fintech.exception.SaldoMenorTransferenciaException;
import br.com.liberato.fintech.repository.ContaRepository;
import br.com.liberato.fintech.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    TransferenciaRepository transferenciaRepository;

    public List<Conta> buscarTodas() {
        return contaRepository.findAll();
    }

    public Conta buscarPorNumero(String numeroConta) {
        return contaRepository.findById(numeroConta)
                .orElseThrow(() -> new ContaInexistenteException(numeroConta));
    }

    public List<Transferencia> buscarTransferenciasPorConta(String numeroConta) {
        Conta conta = contaRepository.findById(numeroConta)
                .orElseThrow(() -> new ContaInexistenteException(numeroConta));
        return transferenciaRepository.findByContaOrigem(conta);
    }

    public Double enviarTransferencia(Transferencia transferencia) {
        Conta conta = transferencia.getContaOrigem();
        conta = buscarPorNumero(conta.getNumero());
        Double valorTransferencia = transferencia.getValor() + transferencia.getTaxa();
        if (transferencia.getValor() + transferencia.getTaxa() > conta.getSaldo()) {
            throw new SaldoMenorTransferenciaException(conta.getSaldo(), valorTransferencia);
        }
        conta.setSaldo(conta.getSaldo() - valorTransferencia);
        Conta contaAtualizada = contaRepository.save(conta);
        return contaAtualizada.getSaldo();
    }

    public Double receberTransferencia(Conta conta, Double valorTransferencia) {
        conta = buscarPorNumero(conta.getNumero());
        Double saldoAtualizado = conta.getSaldo() + valorTransferencia;
        conta.setSaldo(saldoAtualizado);
        Conta contaAtualizada = contaRepository.save(conta);
        return contaAtualizada.getSaldo();
    }

}
