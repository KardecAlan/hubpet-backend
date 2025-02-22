package com.facomp.pethub.tutelado.domain.emums;

import lombok.Getter;

@Getter
public enum Pelagem {

    AMARELA( "Amarela"),
    ARAME( "Arame"),
    ARLEQUIM( "Arlequim"),
    AVELA( "Avelã"),
    AZUL( "Azul"),
    BELTON( "Belton"),
    BOCOLORES( "Bocolores"),
    BRANCA( "Branca"),
    BRONZE( "Bronze"),
    CANELA( "Canela"),
    CASTANHA( "Castanha"),
    CASTANHO_ACINZENTADO( "Castanho acinzentado"),
    CASTANHO_CLARO( "Castanho claro"),
    CASTANHO_ESCURO( "Castanho escuro"),
    CERDOSA( "Cerdosa"),
    CHOCOLATE( "Chocolate"),
    CINZA_CLARO( "Cinza claro"),
    CINZA_ESCURO( "Cinza escuro"),
    CINZENTA( "Cinzenta"),
    COMBINACOES_COM_FULVO( "Combinações com fulvo"),
    CREME( "Creme"),
    CURTA( "Curta"),
    DOURADA( "Dourada"),
    DUPLA( "Dupla"),
    DUPLA_DENSA( "Dupla densa"),
    DURA( "Dura"),
    ENCARACOLADA( "Encaracolada"),
    FIGADO( "Fígado"),
    FIGADO_ACASTANHADA( "Fígado acastanhada"),
    FULVA( "Fulva"),
    LARANJA( "Laranja"),
    LOBEIRA( "Lobeira"),
    LONGA( "Longa"),
    LONGA_ENCARACOLADA( "Longa encaracolada"),
    LONGA_LISA( "Longa lisa"),
    MARFIM( "Marfim"),
    MERLE( "Merle"),
    MOGNO( "Mogno"),
    MOSTARDA( "Mostarda"),
    PECULIAR( "Peculiar"),
    PINTALGADA( "Pintalgada"),
    PRETA( "Preta"),
    PRETA_FULVA_BRANCA( "Preta fulva branca"),
    RUAO( "Ruão"),
    RUBI( "Rubi"),
    RUCA( "Ruça"),
    SAL_PIMENTA( "Sal pimenta"),
    SEDOSA( "Sedosa"),
    TIGRADO( "Tigrado"),
    VERMELHA( "Vermelha"),
    VERMELHA_AMARELADA( "Vermelha amarelada"),
    VERMELHA_DOURADA( "Vermelha dourada"),
    VERMELHA_ESCURA( "Vermelha escura"),;
    
    private String nome;

    Pelagem(String nome) {
        this.nome = nome;
    }

}
