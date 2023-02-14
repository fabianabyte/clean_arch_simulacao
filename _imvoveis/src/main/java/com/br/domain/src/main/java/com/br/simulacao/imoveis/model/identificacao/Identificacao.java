package com.br.simulacao.model.identificacao;

public interface Identificacao {
    TipoIdentificacao getTipoIdentificacao();
    String getIdentificacaoFormatada();
    void validar() throws IllegalArgumentException;
    Byte calcularDV();

}
