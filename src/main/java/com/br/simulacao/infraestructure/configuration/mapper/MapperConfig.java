package com.br.simulacao.infraestructure.configuration.mapper;

import com.br.simulacao.dataprovider.mapper.PessoaMapper;
import com.br.simulacao.dataprovider.mapper.SimulacaoMapper;
import org.mapstruct.factory.Mappers;

public class MapperConfig {
    private MapperConfig(){}

    public static <T> T factory(final Class<T> clazz){
        return Mappers.getMapper(clazz);
    }

    public static SimulacaoMapper getSimulacaoMapper(){
        return factory(SimulacaoMapper.class);
    }

    public static PessoaMapper getPessoaMapper(){
        return factory(PessoaMapper.class);
    }
}
