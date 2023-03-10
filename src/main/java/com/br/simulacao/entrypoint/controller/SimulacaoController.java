package com.br.simulacao.entrypoint.controller;


import com.br.simulacao.application.usecases.exception.SimulacaoNaoEncontradaException;
import com.br.simulacao.application.usecases.exception.SimulacaoRejeitadaException;
import com.br.simulacao.dataprovider.SimulacaoUseCaseService;
import com.br.simulacao.dataprovider.model.simulacao.Simulacao;
import com.br.simulacao.dataprovider.presenters.SimulacaoPresenter;
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
    SimulacaoUseCaseService simulacaoUseCaseService;
    @NonNull
    SimulacaoPresenter simulacaoPresenter;

    @GetMapping("/")
    public ResponseEntity<List<Simulacao>> obterTodasSimulacoes() {
        try {
            return new ResponseEntity<>(simulacaoUseCaseService.obterTodasSimulacoes(), HttpStatus.OK);
        } catch (SimulacaoNaoEncontradaException e) {
            return simulacaoPresenter.enviarErroSimulacaoNaoEncontrada();
        } catch (Exception e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id_pessoa}")
    public ResponseEntity<List<Simulacao>> obterSimulacoesPessoa(@PathVariable(name = "id_pessoa") String idPessoa) {
        try {
            return new ResponseEntity<>(simulacaoUseCaseService.obterSimulacoesPorPessoa(idPessoa), HttpStatus.OK);
        } catch (SimulacaoNaoEncontradaException e) {
            return simulacaoPresenter.enviarErroSimulacaoNaoEncontrada();
        } catch (Exception e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Simulacao> criarSimulacao(@RequestBody Simulacao simulacao) {
        try {
            return new ResponseEntity<>(simulacaoUseCaseService.criarSimulacao(simulacao), HttpStatus.CREATED);
        } catch (SimulacaoRejeitadaException e) {
            log.error(e.toString());
            return simulacaoPresenter.enviarErroAoGravarSimulacao(e.getMessage());
        } catch (Exception e) {
            log.error(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
