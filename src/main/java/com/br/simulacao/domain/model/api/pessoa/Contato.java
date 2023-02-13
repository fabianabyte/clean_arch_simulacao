package com.br.simulacao.domain.model.api.pessoa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Contato {
    private String logradouro;
    private String email;
    private String telefone;

}
