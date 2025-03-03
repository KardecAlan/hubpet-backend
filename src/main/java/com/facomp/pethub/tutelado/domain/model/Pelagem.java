package com.facomp.pethub.tutelado.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pelagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    public Pelagem(String descricao) {
        this.descricao = descricao;
    }
}
