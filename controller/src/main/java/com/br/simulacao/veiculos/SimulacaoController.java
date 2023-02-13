package com.br.simulacao.controller;


import com.br.simulacao.domain.model.api.simulacao.Simulacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/simulacoes")
public class SimulacaoController {


    @GetMapping("/")
    public ResponseEntity<List<Simulacao>> obterTodasSimulacoes() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id_pessoa}")
    public ResponseEntity<List<Simulacao>> obterSimulacoesPessoa(@PathVariable(name = "id_pessoa") String idPessoa) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<Simulacao> criarSimulacao(@RequestBody Simulacao simulacao) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
