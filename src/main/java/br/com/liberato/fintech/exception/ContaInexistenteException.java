package br.com.liberato.fintech.exception;

public class ContaInexistenteException extends RuntimeException {

    String numeroConta;

    public ContaInexistenteException(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    @Override
    public String toString() {
        return "Não foi possível localizar a conta " + this.numeroConta;
    }
}
