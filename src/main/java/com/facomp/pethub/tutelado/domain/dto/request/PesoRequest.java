package com.facomp.pethub.tutelado.domain.dto.request;

import com.facomp.pethub.tutelado.domain.emums.CondicaoCorporal;
import com.facomp.pethub.tutelado.domain.model.Tutelado;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PesoRequest {

    private LocalDateTime dataCadastro;

    private Float pesoEmKg;

    private CondicaoCorporal condicaoCorporal;

    private String observacao;

    private Tutelado tutelado;
}
