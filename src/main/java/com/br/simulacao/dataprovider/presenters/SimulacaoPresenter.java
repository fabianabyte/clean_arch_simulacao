package com.br.simulacao.dataprovider.presenters;

import org.springframework.http.ResponseEntity;

public interface SimulacaoPresenter {
    ResponseEntity enviarErroAoGravarSimulacao(String erro);
    ResponseEntity enviarErroSimulacaoNaoEncontrada();
}
