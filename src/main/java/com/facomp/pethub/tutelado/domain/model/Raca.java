package com.facomp.pethub.tutelado.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Raca {

    @Id
    @Column(nullable = false, unique = true)
    private String descricao;

    @JsonValue
    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static Raca fromDescricao(String descricao) {
        return Raca.builder().descricao(descricao).build();
    }


}
