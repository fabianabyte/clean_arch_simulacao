package com.br.simulacao.domain.mapper;

import com.br.simulacao.domain.entidade.pessoa.ContatoEntidade;
import com.br.simulacao.domain.entidade.pessoa.ContatoEntidade.ContatoEntidadeBuilder;
import com.br.simulacao.domain.entidade.pessoa.PessoaEntidade;
import com.br.simulacao.domain.entidade.pessoa.PessoaEntidade.PessoaEntidadeBuilder;
import com.br.simulacao.domain.model.api.pessoa.Contato;
import com.br.simulacao.domain.model.api.pessoa.Contato.ContatoBuilder;
import com.br.simulacao.domain.model.api.pessoa.Pessoa;
import com.br.simulacao.domain.model.api.pessoa.Pessoa.PessoaBuilder;
import com.br.simulacao.domain.model.api.pessoa.TipoPessoa;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-11T10:15:36-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
)
@Component
public class PessoaMapperImpl implements PessoaMapper {

    @Override
    public PessoaEntidade converterPessoaEmPessoaEntity(Pessoa pessoa) {
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

    @Override
    public Pessoa converterPessoaEntityEmPessoa(PessoaEntidade pessoaEntidade) {
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

    @Override
    public PessoaEntidade atualizacaoParcial(Pessoa pessoa, PessoaEntidade pessoaEntidade) {
        if ( pessoa == null ) {
            return null;
        }

        if ( pessoa.getContato() != null ) {
            if ( pessoaEntidade.getContato() == null ) {
                pessoaEntidade.setContato( new ContatoEntidade() );
            }
            contatoToContatoEntidade1( pessoa.getContato(), pessoaEntidade.getContato() );
        }
        if ( pessoa.getTipoPessoa() != null ) {
            pessoaEntidade.setTipoPessoa( pessoa.getTipoPessoa().name() );
        }
        if ( pessoa.getNome() != null ) {
            pessoaEntidade.setNome( pessoa.getNome() );
        }

        return pessoaEntidade;
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

    protected void contatoToContatoEntidade1(Contato contato, ContatoEntidade mappingTarget) {
        if ( contato == null ) {
            return;
        }

        if ( contato.getTelefone() != null ) {
            mappingTarget.setTelefone( contato.getTelefone() );
        }
        if ( contato.getEmail() != null ) {
            mappingTarget.setEmail( contato.getEmail() );
        }
        if ( contato.getLogradouro() != null ) {
            mappingTarget.setLogradouro( contato.getLogradouro() );
        }
    }
}
