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
public class Temperamento {

    @Id
    @Column(nullable = false, unique = true)
    private String descricao;

    @JsonValue
    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static Temperamento fromDescricao(String descricao) {
        return Temperamento.builder().descricao(descricao).build();
    }
}
