package br.com.liberato.fintech.service;

import br.com.liberato.fintech.domain.Conta;
import br.com.liberato.fintech.domain.Transferencia;
import br.com.liberato.fintech.exception.SaldoMenorTransferenciaException;
import br.com.liberato.fintech.exception.TaxaIndefinidaException;
import br.com.liberato.fintech.exception.TransferenciaInexistenteException;
import br.com.liberato.fintech.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

@Service
public class TransferenciaService {

    @Autowired
    TransferenciaRepository transferenciaRepository;

    @Autowired
    ContaService contaService;

    public List<Transferencia> buscarTodas() {
        return transferenciaRepository.findAll();
    }

    public List<Transferencia> buscarPorContaOrigem(Conta conta) {
        return transferenciaRepository.findByContaOrigem(conta);
    }

    public Transferencia transferir(Transferencia transferencia) throws SaldoMenorTransferenciaException {
        transferencia.setDataTransferencia(LocalDateTime.now());

        String numeroContaOrigem = transferencia.getContaOrigem().getNumero();
        Conta contaOrigem = contaService.buscarPorNumero(numeroContaOrigem);
        transferencia.setContaOrigem(contaOrigem);

        Double valorTransferencia = transferencia.getValor();
        Conta contaDestino = transferencia.getContaDestino();

        transferencia.setTaxa(calcularTaxa(transferencia));
        contaService.enviarTransferencia(transferencia);
        contaService.receberTransferencia(contaDestino, valorTransferencia);
        return transferenciaRepository.save(transferencia);
    }

    /**
     * Calcula a taxa da transferência conforme a data agendada
     * @param transferencia
     * @return Valor da taxa
     */
    public Double calcularTaxa(Transferencia transferencia) {
        LocalDate dataTransferencia = transferencia.getDataTransferencia().toLocalDate();
        Double taxa = 0.0;
        LocalDate dataAgendada = transferencia.getDataAgendada();
        Integer diasParaTransferencia = Period.between(dataTransferencia, dataAgendada).getDays();

        if (dataAgendada.isBefore(dataTransferencia)) {
            throw new IllegalArgumentException("Data agendada não pode ser anterior a data atual");
        }

        if(dataAgendada.isEqual(dataTransferencia)) {
            taxa = (transferencia.getValor() * 0.03) + 3;
        } else if (diasParaTransferencia > 0 && diasParaTransferencia <= 10) {
            taxa = 12.0;
        } else if (diasParaTransferencia < 20) {
            taxa = (transferencia.getValor() * 8.2) / 100;
        } else if (diasParaTransferencia <= 30) {
            taxa = (transferencia.getValor() * 6.9) / 100;
        } else if (diasParaTransferencia > 30) {
            taxa = (transferencia.getValor() * 4.7) / 100;
        } else if (diasParaTransferencia > 40) {
            taxa = (transferencia.getValor() * 1.7) / 100;
        }

        if (taxa == 0.0) {
            throw new TaxaIndefinidaException(transferencia);
        }
        return taxa;
    }

    public Transferencia buscarPorId(Long idTransferencia) {
        return transferenciaRepository.findById(idTransferencia)
                .orElseThrow(() -> new TransferenciaInexistenteException(idTransferencia));
    }
}
