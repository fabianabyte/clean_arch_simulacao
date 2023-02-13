package com.br.simulacao.domain.mapper;

import com.br.simulacao.domain.entidade.pessoa.ContatoEntidade;
import com.br.simulacao.domain.entidade.pessoa.ContatoEntidade.ContatoEntidadeBuilder;
import com.br.simulacao.domain.entidade.pessoa.PessoaEntidade;
import com.br.simulacao.domain.entidade.pessoa.PessoaEntidade.PessoaEntidadeBuilder;
import com.br.simulacao.domain.entidade.simulacao.ProdutoEntidade;
import com.br.simulacao.domain.entidade.simulacao.ProdutoEntidade.ProdutoEntidadeBuilder;
import com.br.simulacao.domain.entidade.simulacao.SimulacaoEntidade;
import com.br.simulacao.domain.entidade.simulacao.SimulacaoEntidade.SimulacaoEntidadeBuilder;
import com.br.simulacao.domain.model.api.pessoa.Contato;
import com.br.simulacao.domain.model.api.pessoa.Contato.ContatoBuilder;
import com.br.simulacao.domain.model.api.pessoa.Pessoa;
import com.br.simulacao.domain.model.api.pessoa.Pessoa.PessoaBuilder;
import com.br.simulacao.domain.model.api.pessoa.TipoPessoa;
import com.br.simulacao.domain.model.api.simulacao.Produto;
import com.br.simulacao.domain.model.api.simulacao.Produto.ProdutoBuilder;
import com.br.simulacao.domain.model.api.simulacao.Simulacao;
import com.br.simulacao.domain.model.api.simulacao.Simulacao.SimulacaoBuilder;
import com.br.simulacao.domain.model.api.simulacao.TipoProduto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-11T10:15:36-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
)
@Component
public class SimulacaoMapperImpl implements SimulacaoMapper {

    @Override
    public Simulacao converterSimulacaoEntityEmSimulacao(SimulacaoEntidade simulacaoEntidade) {
        if ( simulacaoEntidade == null ) {
            return null;
        }

        SimulacaoBuilder simulacao = Simulacao.builder();

        simulacao.pessoa( pessoaEntidadeToPessoa( simulacaoEntidade.getPessoa() ) );
        simulacao.produto( produtoEntidadeToProduto( simulacaoEntidade.getProduto() ) );
        simulacao.valorEntrada( simulacaoEntidade.getValorEntrada() );
        simulacao.valorPrestacao( simulacaoEntidade.getValorPrestacao() );
        simulacao.quantidadePrestacoes( simulacaoEntidade.getQuantidadePrestacoes() );
        simulacao.valorTotalContrato( simulacaoEntidade.getValorTotalContrato() );
        simulacao.taxaMensal( simulacaoEntidade.getTaxaMensal() );
        simulacao.taxaAnual( simulacaoEntidade.getTaxaAnual() );

        return simulacao.build();
    }

    @Override
    public SimulacaoEntidade converterSimulacaoEmSimulacaoEntity(Simulacao simulacao) {
        if ( simulacao == null ) {
            return null;
        }

        SimulacaoEntidadeBuilder simulacaoEntidade = SimulacaoEntidade.builder();

        simulacaoEntidade.pessoa( pessoaToPessoaEntidade( simulacao.getPessoa() ) );
        simulacaoEntidade.produto( produtoToProdutoEntidade( simulacao.getProduto() ) );
        simulacaoEntidade.valorEntrada( simulacao.getValorEntrada() );
        simulacaoEntidade.valorPrestacao( simulacao.getValorPrestacao() );
        simulacaoEntidade.quantidadePrestacoes( simulacao.getQuantidadePrestacoes() );
        simulacaoEntidade.valorTotalContrato( simulacao.getValorTotalContrato() );
        simulacaoEntidade.taxaMensal( simulacao.getTaxaMensal() );
        simulacaoEntidade.taxaAnual( simulacao.getTaxaAnual() );

        return simulacaoEntidade.build();
    }

    protected Contato contatoEntidadeToContato(ContatoEntidade contatoEntidade) {
        if ( contatoEntidade == null ) {
            return null;
        }

        ContatoBuilder contato = Contato.builder();

        contato.logradouro( contatoEntidade.getLogradouro() );
        contato.email( contatoEntidade.getEmail() );
        contato.telefone( contatoEntidade.getTelefone() );

        return contato.build();
    }

    protected Pessoa pessoaEntidadeToPessoa(PessoaEntidade pessoaEntidade) {
        if ( pessoaEntidade == null ) {
            return null;
        }

        PessoaBuilder pessoa = Pessoa.builder();

        pessoa.nome( pessoaEntidade.getNome() );
        pessoa.contato( contatoEntidadeToContato( pessoaEntidade.getContato() ) );
        pessoa.identificacao( pessoaEntidade.getIdentificacao() );
        if ( pessoaEntidade.getTipoPessoa() != null ) {
            pessoa.tipoPessoa( Enum.valueOf( TipoPessoa.class, pessoaEntidade.getTipoPessoa() ) );
        }

        return pessoa.build();
    }

    protected Produto produtoEntidadeToProduto(ProdutoEntidade produtoEntidade) {
        if ( produtoEntidade == null ) {
            return null;
        }

        ProdutoBuilder produto = Produto.builder();

        if ( produtoEntidade.getTipoProduto() != null ) {
            produto.tipoProduto( Enum.valueOf( TipoProduto.class, produtoEntidade.getTipoProduto() ) );
        }

        return produto.build();
    }

    protected ContatoEntidade contatoToContatoEntidade(Contato contato) {
        if ( contato == null ) {
            return null;
        }

        ContatoEntidadeBuilder contatoEntidade = ContatoEntidade.builder();

        contatoEntidade.telefone( contato.getTelefone() );
        contatoEntidade.email( contato.getEmail() );
        contatoEntidade.logradouro( contato.getLogradouro() );

        return contatoEntidade.build();
    }

    protected PessoaEntidade pessoaToPessoaEntidade(Pessoa pessoa) {
        if ( pessoa == null ) {
            return null;
        }

        PessoaEntidadeBuilder pessoaEntidade = PessoaEntidade.builder();

        pessoaEntidade.identificacao( pessoa.getIdentificacao() );
        pessoaEntidade.contato( contatoToContatoEntidade( pessoa.getContato() ) );
        if ( pessoa.getTipoPessoa() != null ) {
            pessoaEntidade.tipoPessoa( pessoa.getTipoPessoa().name() );
        }
        pessoaEntidade.nome( pessoa.getNome() );

        return pessoaEntidade.build();
    }

    protected ProdutoEntidade produtoToProdutoEntidade(Produto produto) {
        if ( produto == null ) {
            return null;
        }

        ProdutoEntidadeBuilder produtoEntidade = ProdutoEntidade.builder();

        if ( produto.getTipoProduto() != null ) {
            produtoEntidade.tipoProduto( produto.getTipoProduto().name() );
        }

        return produtoEntidade.build();
    }
}
