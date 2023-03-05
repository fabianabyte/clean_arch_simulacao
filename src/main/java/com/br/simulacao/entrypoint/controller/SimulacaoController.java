package com.br.simulacao.entrypoint.controller;


import com.br.simulacao.dataprovider.SimulacaoUseCaseService;
import com.br.simulacao.dataprovider.model.simulacao.Simulacao;
import com.br.simulacao.dataprovider.service.SimulacaoDataProviderService;
import lombok.NonNull;
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

    @NonNull
    SimulacaoDataProviderService simulacaoDataProviderService;
    @NonNull
    SimulacaoUseCaseService simulacaoUseCaseService;

    @GetMapping("/")
    public ResponseEntity<List<Simulacao>> obterTodasSimulacoes() {
        try {
            List<Simulacao> simulacoes = simulacaoUseCaseService.obterTodasSimulacoes();

            if (simulacoes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(simulacoes, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id_pessoa}")
    public ResponseEntity<List<Simulacao>> obterSimulacoesPessoa(@PathVariable(name = "id_pessoa") String idPessoa) {
        try {
            List<Simulacao> simulacoes = simulacaoUseCaseService.obterSimulacoesPorPessoa(idPessoa);

            if (simulacoes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(simulacoes, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Simulacao> criarSimulacao(@RequestBody Simulacao simulacao) {
        try {
            return new ResponseEntity<>(simulacaoUseCaseService.criarSimulacao(simulacao), HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
