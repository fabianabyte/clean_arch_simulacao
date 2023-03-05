package com.br.simulacao.dataprovider.model.pessoa;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pessoa {
    private String nome;

    private LocalDate dataNascimento;
    private Contato contato;
    private String identificacao;
    private TipoPessoa tipoPessoa;
}
