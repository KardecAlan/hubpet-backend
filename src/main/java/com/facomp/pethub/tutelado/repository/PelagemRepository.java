package com.facomp.pethub.tutelado.repository;

import com.facomp.pethub.tutelado.domain.model.Pelagem;
import com.facomp.pethub.tutelado.domain.model.Tutelado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PelagemRepository extends JpaRepository<Pelagem, Long>, JpaSpecificationExecutor<Tutelado> {

    Optional<Pelagem> findByDescricaoIgnoreCase(String descricao);
}
