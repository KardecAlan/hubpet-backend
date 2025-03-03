package com.facomp.pethub.tutelado.repository;

import com.facomp.pethub.tutelado.domain.model.Raca;
import com.facomp.pethub.tutelado.domain.model.Tutelado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RacaRepository extends JpaRepository<Raca, Long>, JpaSpecificationExecutor<Tutelado> {

    Optional<Raca> findByDescricaoIgnoreCase(String descricao);
}
