package com.facomp.pethub.tutelado.domain.emums;

import lombok.Getter;

@Getter
public enum Castrado {

    SIM("Sim"),
    NAO("Não"),
    INDEFINIDO("Indefinido");

    private final String nome;

    Castrado(String nome) {
        this.nome = nome;
    }
}
