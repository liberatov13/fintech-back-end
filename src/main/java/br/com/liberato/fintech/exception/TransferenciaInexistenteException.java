package br.com.liberato.fintech.exception;

public class TransferenciaInexistenteException extends RuntimeException {
    Long idTransferencia;

    public TransferenciaInexistenteException(Long idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    @Override
    public String toString() {
        return "Não foi possível localizar a transferência " + this.idTransferencia;
    }
}
