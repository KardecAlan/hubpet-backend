package com.facomp.pethub.tutelado.domain.dto.response;

import com.facomp.pethub.tutelado.domain.emums.CondicaoCorporal;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PesoResponse {

    private Long id;

    private Long versao;

    private LocalDateTime dataCadastro;

    private Float pesoEmKg;

    private CondicaoCorporal condicaoCorporal;

    private String observacao;
}
