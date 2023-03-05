package com.br.simulacao.dataprovider.model.simulacao;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    private String nome;
    private TipoProduto tipoProduto;
}
