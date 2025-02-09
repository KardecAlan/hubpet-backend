package com.facomp.pethub.vacina.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public enum TipoVacina {

    ANTIRRABICA(0, "Antirrábica"),
    ANTITETANICA(1, "Antitetânica"),
    DERMATOFITOSE(2, "Dermatofitose"),
    ESPECIFICA(3, "Específica"),
    FELV(4, "FeLV"),
    GIARDIA(5, "Giárdia"),
    LEISHMANIOSE_VISCERAL(6, "Leishmaniose Visceral"),
    LEPTOSPIROSE(7, "Leptospirose"),
    MULTIPLA(8, "Múltipla"),
    TOSSE_DOS_CANIS(9, "Tosse dos Canis"),
    V3(10, "V3"),
    V4(11, "V4"),
    V5(12, "V5"),
    V6(13, "V6"),
    V8(14, "V8"),
    V10(15, "V10"),
    V11(16, "V11"),
    V12(17, "V12");

    private final Integer id;

    @Getter
    private final String nome;

    TipoVacina(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @JsonValue
    public Integer getId() {
        return id;
    }

    private static final Map<Integer, TipoVacina> byId = new HashMap<>();
    static {
        for (TipoVacina e : TipoVacina.values()) {
            if (byId.put(e.getId(), e) != null) {
                throw new IllegalArgumentException("duplicate id: " + e.getId());
            }
        }
    }

}
