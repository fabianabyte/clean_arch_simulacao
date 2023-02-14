package com.br.simulacao.model.api.pessoa;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pessoa {
    private String nome;
    private Contato contato;
    private String identificacao;
    private TipoPessoa tipoPessoa;
}
