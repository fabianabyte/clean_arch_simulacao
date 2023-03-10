package com.br.simulacao.dataprovider.presenters;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SimulacaoPresenterImpl implements SimulacaoPresenter{

    @Override
    public ResponseEntity enviarErroAoGravarSimulacao(String erro) {
        throw new ResponseStatusException(HttpStatus.PRECONDITION_REQUIRED, erro);
    }

    @Override
    public ResponseEntity enviarErroSimulacaoNaoEncontrada() {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
