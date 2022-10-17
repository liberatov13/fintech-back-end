package br.com.liberato.fintech.exceptionhandler;

import br.com.liberato.fintech.exception.ContaInexistenteException;
import br.com.liberato.fintech.exception.SaldoMenorTransferenciaException;
import br.com.liberato.fintech.exception.TransferenciaInexistenteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class FinTechExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ContaInexistenteException.class)
    public ResponseEntity<String> handlerResourceContaInexistenteExecption(ContaInexistenteException contaInexistenteException) {
        return new ResponseEntity<>(contaInexistenteException.toString(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SaldoMenorTransferenciaException.class)
    public ResponseEntity<String> handlerResourceContaInexistenteExecption(SaldoMenorTransferenciaException saldoMenorTransferenciaException) {
        return new ResponseEntity<>(saldoMenorTransferenciaException.toString(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TransferenciaInexistenteException.class)
    public ResponseEntity<String> handlerResourceContaInexistenteExecption(TransferenciaInexistenteException transferenciaInexistenteException) {
        return new ResponseEntity<>(transferenciaInexistenteException.toString(), HttpStatus.NOT_FOUND);
    }

}
