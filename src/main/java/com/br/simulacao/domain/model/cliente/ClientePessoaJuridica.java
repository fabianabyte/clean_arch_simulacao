package com.br.simulacao.domain.model.cliente;

import com.br.simulacao.domain.model.identificacao.Identificacao;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class ClientePessoaJuridica implements Cliente{
    private Identificacao identificacao;
    private String razaoSocial;
    private LocalDate dataFundacao;
    @Override
    public void validar() throws Exception {
        identificacao.validar();
    }

    @Override
    public String getNomeOuRazaoSocial() {
        return getRazaoSocial();
    }

    @Override
    public Identificacao getIdentificacao() {
        return identificacao;
    }

    @Override
    public LocalDate getDataNascimentoOuFundacao() {
        return getDataFundacao();
    }
}
