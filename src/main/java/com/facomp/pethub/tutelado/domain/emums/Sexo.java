package com.facomp.pethub.tutelado.domain.emums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public enum Sexo {

    MACHO(0, "Macho"),
    FEMEA(1, "Fêmea");

    private final Integer id;

    @Getter
    private String nome;

    Sexo(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @JsonValue
    public Integer getId() {
        return id;
    }

    private static final Map<Integer, Sexo> byId = new HashMap<>();
    static {
        for (Sexo e : Sexo.values()) {
            if (byId.put(e.getId(), e) != null) {
                throw new IllegalArgumentException("duplicate id: " + e.getId());
            }
        }
    }

}
