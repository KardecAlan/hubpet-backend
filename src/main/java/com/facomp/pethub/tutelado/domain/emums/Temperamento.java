package com.facomp.pethub.tutelado.domain.emums;

import lombok.Getter;

@Getter
public enum Temperamento {

    AFETUOSO( "Afetuoso"),
    AGIL( "Ágil"),
    AGRESSIVO( "Agressivo"),
    ALERTA( "Alerta"),
    ALTERADO( "Alterado"),
    ASSUSTADO( "Assustado"),
    ATIVO( "Ativo"),
    CORAJOSO( "Corajoso"),
    COVARDE( "Covarde"),
    CURIOSO( "Curioso"),
    DOCIL( "Dócil"),
    ESTRESSADO("Estressado"),
    FEROZ("Feroz"),
    HIPERATIVO("Hiperativo"),
    IRRITADO("Irritado"),
    PREGUICOSO("Preguiçoso"),
    SEDENTARIO("Sedentário"),
    TERRITORIALISTA("Territorialista"),
    TIMIDO("Tímido"),
    TRANQUILO("Tranquilo"),;

    private String nome;

    Temperamento(String name) {
        this.nome = name;
    }
    

}
