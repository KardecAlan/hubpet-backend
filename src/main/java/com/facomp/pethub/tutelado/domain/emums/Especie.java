package com.facomp.pethub.tutelado.domain.emums;

import lombok.Getter;

@Getter
public enum Especie {

    AVE("Ave"),
    BOVINO( "Bovino"),
    BUBALINO( "Bubalino"),
    CANINO( "Canino"),
    CAPRINO( "Caprino"),
    COELHO( "Coelho"),
    EQUINO( "Equino"),
    FELINO( "Felino"),
    OVINO( "Ovino"),
    PEIXE( "Peixe"),
    SUINO( "Suíno");

    private final String nome;

    Especie(String nome) {
        this.nome = nome;
    }

}
