package com.br.simulacao.model.api.simulacao;

import com.br.simulacao.domain.model.api.pessoa.Pessoa;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Simulacao {
    private Pessoa pessoa;
    private Produto produto;
    private Double valorEntrada;
    private Double valorPrestacao;
    private Integer quantidadePrestacoes;
    private Double valorTotalContrato;
    private Double taxaMensal;
    private Double taxaAnual;
}
