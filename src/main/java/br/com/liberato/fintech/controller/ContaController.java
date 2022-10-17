package br.com.liberato.fintech.controller;

import br.com.liberato.fintech.domain.Conta;
import br.com.liberato.fintech.domain.Transferencia;
import br.com.liberato.fintech.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    ContaService contaService;

    @GetMapping
    public ResponseEntity<List<Conta>> buscarTodas() {
        List<Conta> contas = contaService.buscarTodas();
        return new ResponseEntity<>(contas, HttpStatus.OK);
    }

    @GetMapping("/{numeroConta}")
    public ResponseEntity<Conta> buscarPorNumero(@PathVariable String numeroConta) {
        Conta conta = contaService.buscarPorNumero(numeroConta);
        return new ResponseEntity<>(conta, HttpStatus.OK);
    }

    @GetMapping("/{numeroConta}/transferencias")
    public ResponseEntity<List<Transferencia>> buscarTransferencias(@PathVariable String numeroConta) {
        List<Transferencia> transferencias = contaService.buscarTransferenciasPorConta(numeroConta);
        return new ResponseEntity<>(transferencias, HttpStatus.OK);
    }

}
