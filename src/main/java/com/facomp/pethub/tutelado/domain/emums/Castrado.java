package com.facomp.pethub.tutelado.domain.emums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public enum Castrado {

    SIM(0, "Sim"),
    NAO(1, "Não"),
    INDEFINIDO(2, "Indefinido");

    private final Integer id;

    @Getter
    private final String nome;

    Castrado(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @JsonValue
    public Integer getId() {
        return id;
    }

    private static final Map<Integer, Castrado> byId = new HashMap<>();
    static {
        for (Castrado e : Castrado.values()) {
            if (byId.put(e.getId(), e) != null) {
                throw new IllegalArgumentException("duplicate id: " + e.getId());
            }
        }
    }
}
