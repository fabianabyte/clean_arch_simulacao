package com.br.simulacao.application.domain.model.pessoa;

import com.br.simulacao.application.domain.model.identificacao.TipoIdentificacao;
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
    private TipoIdentificacao tipoIdentificacao;
}
