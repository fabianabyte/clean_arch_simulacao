package com.br.simulacao.application.domain.model.simulacao;

import com.br.simulacao.dataprovider.model.simulacao.TipoProduto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Produto {
    private String nome;
    private TipoProduto tipoProduto;
}
