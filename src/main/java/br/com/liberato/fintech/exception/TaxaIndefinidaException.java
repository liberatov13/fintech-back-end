package br.com.liberato.fintech.exception;

import br.com.liberato.fintech.domain.Transferencia;

public class TaxaIndefinidaException extends RuntimeException {

    private Transferencia transferencia;

    public TaxaIndefinidaException(Transferencia transferencia) {
        this.transferencia = transferencia;
    }

    @Override
    public String toString() {
        return "Não foi possível calcular a taxa para a transferência de " + transferencia.getValor() + " para a data de " + transferencia.getDataAgendada();
    }
}
