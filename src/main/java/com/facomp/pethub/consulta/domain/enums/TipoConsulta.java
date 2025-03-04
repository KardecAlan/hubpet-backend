package com.facomp.pethub.consulta.domain.enums;

import lombok.Getter;

@Getter
public enum TipoConsulta {

    PADRAO("Padrão"),
    DETALHADA("Detalhada");

    private final String nome;

    TipoConsulta(String nome) {
        this.nome = nome;
    }
}
