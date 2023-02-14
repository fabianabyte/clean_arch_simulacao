package com.br.simulacao.model.api.simulacao;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum TipoProduto {
    VEICULO("Veículo", 1),
    IMOVEL("Imóvel", 2),
    EMPRESTIMO("Empréstimo", 3);

    private String descricao;
    private Integer id;
    private TipoProduto(String descricao, Integer id){
            this.descricao = descricao;
            this.id = id;
    }
}
