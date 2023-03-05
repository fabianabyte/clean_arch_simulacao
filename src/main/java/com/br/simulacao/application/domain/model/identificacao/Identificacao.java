package com.br.simulacao.application.domain.model.identificacao;

public interface Identificacao {
    TipoIdentificacao getTipoIdentificacao();
    String getIdentificacaoFormatada();
    void validar() throws IllegalArgumentException;
    Byte calcularDV();

}
