package com.br.simulacao.utils.cliente;

import com.br.simulacao.domain.model.cliente.Cliente;
import com.br.simulacao.domain.model.cliente.ClientePessoaFisica;
import com.br.simulacao.domain.model.cliente.ClientePessoaJuridica;
import com.br.simulacao.domain.model.identificacao.Identificacao;
import com.br.simulacao.domain.model.identificacao.TipoIdentificacao;

public class ClienteFactory {
    private ClienteFactory(){}

    public static Cliente gerarPorIdentificacao(Identificacao identificacao){
        Cliente retorno = ClientePessoaFisica.builder()
                .identificacao(identificacao)
                .build();

        if(identificacao.getTipoIdentificacao().equals(TipoIdentificacao.CNPJ)){
            retorno = ClientePessoaJuridica.builder()
                    .identificacao(identificacao)
                    .build();
        }

        return retorno;
    }
    public static Cliente gerarPessoaFisica(Identificacao cpf){
        return ClientePessoaFisica.builder()
                .identificacao(cpf)
                .build();
    }
    public static Cliente gerarPessoaJuridica(Identificacao cnpj){
        return ClientePessoaJuridica.builder()
                .identificacao(cnpj)
                .build();
    }
}
