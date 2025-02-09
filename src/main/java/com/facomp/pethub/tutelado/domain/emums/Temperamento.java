package com.facomp.pethub.tutelado.domain.emums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public enum Temperamento {

    AFETUOSO(0, "Afetuoso"),
    AGIL(1, "Ágil"),
    AGRESSIVO(2, "Agressivo"),
    ALERTA(3, "Alerta"),
    ALTERADO(4, "Alterado"),
    ASSUSTADO(5, "Assustado"),
    ATIVO(6, "Ativo"),
    CORAJOSO(7, "Corajoso"),
    COVARDE(8, "Covarde"),
    CURIOSO(9, "Curioso"),
    DOCIL(10, "Dócil"),
    ESTRESSADO(11, "Estressado"),
    FEROZ(12, "Feroz"),
    HIPERATIVO(13, "Hiperativo"),
    IRRITADO(14, "Irritado"),
    PREGUIÇOSO(15, "Preguiçoso"),
    SEDENTARIO(16, "Sedentário"),
    TERRITORIALISTA(17, "Territorialista"),
    TIMIDO(18, "Tímido"),
    TRANQUILO(19, "Tranquilo"),;

    private static final Map<Integer, Temperamento> byId = new HashMap<>();
    static {
        for (Temperamento e : Temperamento.values()) {
            if (byId.put(e.getId(), e) != null) {
                throw new IllegalArgumentException("duplicate id: " + e.getId());
            }
        }
    }

    private final Integer id;

    @Getter
    private String nome;

    Temperamento(Integer id, String name) {
        this.id = id;
        this.nome = name;
    }

    @JsonValue
    public Integer getId() {
        return id;
    }

}
