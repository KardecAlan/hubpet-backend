package com.facomp.pethub.tutelado.domain.emums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public enum Pelagem {

    AMARELA(0, "Amarela"),
    ARAME(1, "Arame"),
    ARLEQUIM(2, "Arlequim"),
    AVELA(3, "Avelã"),
    AZUL(4, "Azul"),
    BELTON(5, "Belton"),
    BOCOLORES(6, "Bocolores"),
    BRANCA(7, "Branca"),
    BRONZE(8, "Bronze"),
    CANELA(9, "Canela"),
    CASTANHA(10, "Castanha"),
    CASTANHO_ACINZENTADO(11, "Castanho acinzentado"),
    CASTANHO_CLARO(12, "Castanho claro"),
    CASTANHO_ESCURO(13, "Castanho escuro"),
    CERDOSA(14, "Cerdosa"),
    CHOCOLATE(15, "Chocolate"),
    CINZA_CLARO(16, "Cinza claro"),
    CINZA_ESCURO(17, "Cinza escuro"),
    CINZENTA(18, "Cinzenta"),
    COMBINAÇOES_COM_FULVO(19, "Combinações com fulvo"),
    CREME(20, "Creme"),
    CURTA(21, "Curta"),
    DOURADA(22, "Dourada"),
    DUPLA(23, "Dupla"),
    DUPLA_DENSA(24, "Dupla densa"),
    DURA(25, "Dura"),
    ENCARACOLADA(26, "Encaracolada"),
    FIGADO(27, "Fígado"),
    FIGADO_ACASTANHADA(28, "Fígado acastanhada"),
    FULVA(29, "Fulva"),
    LARANJA(30, "Laranja"),
    LOBEIRA(31, "Lobeira"),
    LONGA(32, "Longa"),
    LONGA_ENCARACOLADA(33, "Longa encaracolada"),
    LONGA_LISA(34, "Longa lisa"),
    MARFIM(35, "Marfim"),
    MERLE(36, "Merle"),
    MOGNO(37, "Mogno"),
    MOSTARDA(38, "Mostarda"),
    PECULIAR(39, "Peculiar"),
    PINTALGADA(40, "Pintalgada"),
    PRETA(41, "Preta"),
    PRETA_FULVA_BRANCA(42, "Preta fulva branca"),
    RUAO(43, "Ruão"),
    RUBI(44, "Rubi"),
    RUCA(45, "Ruça"),
    SAL_PIMENTA(46, "Sal pimenta"),
    SEDOSA(47, "Sedosa"),
    TIGRADOA(48, "Tigrado"),
    VERMELHA(49, "Vermelha"),
    VEMELHA_AMARELADA(50, "Vermelha amarelada"),
    VEMELHRA_DOURADA(51, "Vermelha dourada"),
    VERMELHA_ESCURA(52, "Vermelha escura"),;


    private final Integer id;

    @Getter
    private String nome;

    Pelagem(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @JsonValue
    public Integer getId() {
        return id;
    }

    private static final Map<Integer, Pelagem> byId = new HashMap<>();
    static {
        for (Pelagem e : Pelagem.values()) {
            if (byId.put(e.getId(), e) != null) {
                throw new IllegalArgumentException("duplicate id: " + e.getId());
            }
        }
    }

}
