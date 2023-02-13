package com.br.simulacao.domain.mapper;

import com.br.simulacao.domain.entidade.pessoa.PessoaEntidade;
import com.br.simulacao.domain.model.api.pessoa.Pessoa;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PessoaMapper {

    PessoaEntidade converterPessoaEmPessoaEntity(Pessoa pessoa);

    Pessoa converterPessoaEntityEmPessoa(PessoaEntidade pessoaEntidade);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PessoaEntidade atualizacaoParcial(Pessoa pessoa, @MappingTarget PessoaEntidade pessoaEntidade);
}