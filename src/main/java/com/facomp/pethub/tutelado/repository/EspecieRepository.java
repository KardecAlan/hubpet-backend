package com.facomp.pethub.tutelado.repository;

import com.facomp.pethub.tutelado.domain.model.Especie;
import com.facomp.pethub.tutelado.domain.model.Tutelado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Long>, JpaSpecificationExecutor<Tutelado> {

    Optional<Especie> findByDescricaoIgnoreCase(String descricao);
}
