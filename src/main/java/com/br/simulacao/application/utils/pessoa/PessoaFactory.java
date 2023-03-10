package com.br.simulacao.application.utils.pessoa;

import com.br.simulacao.application.domain.model.pessoa.TipoPessoa;
import com.br.simulacao.application.utils.identificacao.IdentificacaoFactory;
import com.br.simulacao.dataprovider.model.entidade.pessoa.PessoaEntidade;
import com.br.simulacao.application.domain.model.identificacao.TipoIdentificacao;

public class PessoaFactory {
    private PessoaFactory(){}

    public static PessoaEntidade gerarPessoaPorIdentificacao(String identificacao){
        return PessoaEntidade.builder()
                .tipoPessoa(IdentificacaoFactory.getIdentificacao(identificacao).getTipoIdentificacao().getDescricao())
                .identificacao(identificacao)
                .build();
    }
    public static PessoaEntidade gerarPessoaFisica(String identificacao){
        return PessoaEntidade.builder()
                .tipoPessoa(TipoPessoa.CPF.getDescricao())
                .identificacao(identificacao)
                .build();
    }
    public static PessoaEntidade gerarPessoaJuridica(String identificacao){
        return PessoaEntidade.builder()
                .tipoPessoa(TipoPessoa.CNPJ.getDescricao())
                .identificacao(identificacao)
                .build();
    }
    public static PessoaEntidade gerarPessoa(String identificacao, TipoIdentificacao tipoIdentificacao){
        return PessoaEntidade.builder()
                .tipoPessoa(tipoIdentificacao.getDescricao())
                .identificacao(identificacao)
                .build();
    }
}
