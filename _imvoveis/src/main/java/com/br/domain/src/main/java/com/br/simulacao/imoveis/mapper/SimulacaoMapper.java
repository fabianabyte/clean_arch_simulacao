package com.br.simulacao.mapper;

import com.br.simulacao.domain.model.api.simulacao.Simulacao;
import com.br.simulacao.domain.entidade.simulacao.SimulacaoEntidade;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SimulacaoMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Simulacao converterSimulacaoEntityEmSimulacao(SimulacaoEntidade simulacaoEntidade);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SimulacaoEntidade converterSimulacaoEmSimulacaoEntity(Simulacao simulacao);

}
