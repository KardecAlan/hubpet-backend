package com.facomp.pethub.tutelado.domain.emums;

import lombok.Getter;

@Getter
public enum Porte {

    PEQUENO("Pequeno"),
    MEDIO("Médio"),
    GRANDE("Grande");

    private String nome;

    Porte(String nome) {
        this.nome = nome;
    }

}
