package com.br.simulacao.domain.model.cliente;

import com.br.simulacao.domain.model.identificacao.Identificacao;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class ClientePessoaFisica implements Cliente {

    private String nome;
    private LocalDate dataNascimento;
    private Identificacao identificacao;
    public void validar() throws Exception{
        identificacao.validar();
    }

    @Override
    public String getNomeOuRazaoSocial() {
        return getNome();
    }

    public Identificacao getIdentificacao(){
        return identificacao;
    }

    @Override
    public LocalDate getDataNascimentoOuFundacao() {
        return getDataNascimento();
    }
}
