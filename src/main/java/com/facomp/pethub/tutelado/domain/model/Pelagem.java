package com.facomp.pethub.tutelado.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pelagem {

    @Id
    @Column(nullable = false, unique = true)
    private String descricao;

    @JsonValue
    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static Pelagem fromDescricao(String descricao) {
        return Pelagem.builder().descricao(descricao).build();
    }
}
