package com.facomp.pethub.tutelado.domain.emums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public enum Especie {

    AVE(0, "Ave"),
    BOVINO(1, "Bovino"),
    BUBALINO(2, "Bubalino"),
    CANINO(3, "Canino"),
    CAPRINO(4, "Caprino"),
    COELHO(5, "Coelho"),
    EQUINO(6, "Equino"),
    FELINO(7, "Felino"),
    OVINO(8, "Ovino"),
    PEIXE(9, "Peixe"),
    SUINO(10, "Suíno");


    private final Integer id;

    @Getter
    private final String nome;

    Especie(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @JsonValue
    public Integer getId() {
        return id;
    }

    private static final Map<Integer, Especie> byId = new HashMap<>();
    static {
        for (Especie e : Especie.values()) {
            if (byId.put(e.getId(), e) != null) {
                throw new IllegalArgumentException("duplicate id: " + e.getId());
            }
        }
    }

}
