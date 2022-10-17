package br.com.liberato.fintech.controller;

import br.com.liberato.fintech.domain.Transferencia;
import br.com.liberato.fintech.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    @Autowired
    TransferenciaService transferenciaService;

    @PostMapping
    public ResponseEntity<Transferencia> cadastrar(@RequestBody Transferencia transferencia, HttpServletResponse response, HttpServletRequest request) {
        Transferencia transferenciaSalva = transferenciaService.transferir(transferencia);
        String uri = ServletUriComponentsBuilder.fromCurrentRequest().toUriString();
        response.setHeader("Location", uri + "/" + transferenciaSalva.getIdTransferencia());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{idTransferencia}")
    public ResponseEntity<Transferencia> transferenciaResponseEntity(@PathVariable Long idTransferencia) {
        Transferencia transferencia = transferenciaService.buscarPorId(idTransferencia);
        return new ResponseEntity<>(transferencia, HttpStatus.OK);
    }
}
