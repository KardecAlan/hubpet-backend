package com.facomp.pethub.tutelado.repository;


import com.facomp.pethub.tutelado.domain.model.Vacina;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Long>, JpaSpecificationExecutor<Vacina> {

    Page<Vacina> findByTutelado_Id(Long id, Pageable paginacao);

    Optional<Vacina> findByIdAndTutelado_Id(Long idPeso, Long idTutelado);
}
