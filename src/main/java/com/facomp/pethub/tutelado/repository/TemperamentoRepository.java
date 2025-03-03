package com.facomp.pethub.tutelado.repository;

import com.facomp.pethub.tutelado.domain.model.Temperamento;
import com.facomp.pethub.tutelado.domain.model.Tutelado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TemperamentoRepository extends JpaRepository<Temperamento, Long>, JpaSpecificationExecutor<Tutelado> {

    Optional<Temperamento> findByDescricaoIgnoreCase(String descricao);
}
