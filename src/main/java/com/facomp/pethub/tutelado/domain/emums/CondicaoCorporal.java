package com.facomp.pethub.tutelado.domain.emums;

import lombok.Getter;

@Getter
public enum CondicaoCorporal {

    MUITO_MAGRO("Muito magro"),
    IDEAL("Ideal"),
    ACIMA_DO_IDEAL("Acima do ideal"),
    SOBREPESO("Sobrepeso"),
    OBESO("Obeso");

    private final String nome;

    CondicaoCorporal(String nome) {
        this.nome = nome;
    }
}
