package br.com.liberato.fintech.exception;

public class SaldoMenorTransferenciaException extends RuntimeException {

    Double saldo;
    Double transferencia;

    public SaldoMenorTransferenciaException(Double saldo, Double transferencia) {
        this.saldo = saldo;
        this.transferencia = transferencia;
    }

    @Override
    public String toString() {
        return "Transferência de " + this.transferencia + " ultrapassa o saldo atual de " + this.saldo;
    }
}
