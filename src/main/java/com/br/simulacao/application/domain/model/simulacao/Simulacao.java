package com.br.simulacao.application.domain.model.simulacao;

import com.br.simulacao.application.domain.model.pessoa.Pessoa;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Simulacao {
    private Pessoa pessoa;
    private Produto produto;
    private LocalDate dataSimulacao;
    private Double valorEntrada;
    private Double valorPrestacao;
    private Integer quantidadePrestacoes;
    private Double valorTotalContrato;
    private Double taxaMensal;
    private Double taxaAnual;
}
