package com.facomp.pethub.tutelado.domain.emums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public enum Porte {

    PEQUENO(0, "Pequeno"),
    MEDIO(1, "Médio"),
    GRANDE(2, "Grande");

    private final Integer id;

    @Getter
    private String nome;

    Porte(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @JsonValue
    public Integer getId() {
        return id;
    }

    private static final Map<Integer, Porte> byId = new HashMap<>();
    static {
        for (Porte e : Porte.values()) {
            if (byId.put(e.getId(), e) != null) {
                throw new IllegalArgumentException("duplicate id: " + e.getId());
            }
        }
    }
}
