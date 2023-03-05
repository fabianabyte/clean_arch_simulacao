package com.br.simulacao.dataprovider.mapper;

import com.br.simulacao.dataprovider.model.simulacao.Simulacao;
import com.br.simulacao.dataprovider.model.entidade.simulacao.SimulacaoEntidade;
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

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Simulacao converterSimulacaoNegocioEmSimulacaoProvider(com.br.simulacao.application.domain.model.simulacao.Simulacao simulacao);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    com.br.simulacao.application.domain.model.simulacao.Simulacao converterSimulacaoProviderEmSimulacaoNegocio(Simulacao simulacao);

}
