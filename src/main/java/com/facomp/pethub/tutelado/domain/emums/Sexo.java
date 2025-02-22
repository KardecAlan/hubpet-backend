package com.facomp.pethub.tutelado.domain.emums;

import lombok.Getter;

@Getter
public enum Sexo {

    MACHO("Macho"),
    FEMEA("Fêmea");

    private String nome;

    Sexo(String nome) {
        this.nome = nome;
    }

}
