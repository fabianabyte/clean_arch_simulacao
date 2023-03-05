package com.br.simulacao.dataprovider.mapper;

import com.br.simulacao.dataprovider.model.entidade.pessoa.PessoaEntidade;
import com.br.simulacao.dataprovider.model.pessoa.Pessoa;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PessoaMapper {

    PessoaEntidade converterPessoaEmPessoaEntity(Pessoa pessoa);

    Pessoa converterPessoaEntityEmPessoa(PessoaEntidade pessoaEntidade);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PessoaEntidade atualizacaoParcial(Pessoa pessoa, @MappingTarget PessoaEntidade pessoaEntidade);
}