package com.facomp.pethub.tutelado.repository;

import com.facomp.pethub.tutelado.domain.model.Consulta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>, JpaSpecificationExecutor<Consulta> {

    Page<Consulta> findByTutelado_IdAndConsultaCanceladaIsFalse(Long id, Pageable paginacao);

    List<Consulta> findByDataConsultaBetween(LocalDateTime localDateTime, LocalDateTime fim);

    List<Consulta> findByDataConsultaBetweenAndIdNot(LocalDateTime localDateTime, LocalDateTime fim, Long idConsulta);

}
