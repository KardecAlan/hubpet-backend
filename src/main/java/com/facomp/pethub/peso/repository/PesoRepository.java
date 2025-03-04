package com.facomp.pethub.peso.repository;

import com.facomp.pethub.peso.domain.model.Peso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PesoRepository extends JpaRepository<Peso, Long>, JpaSpecificationExecutor<Peso> {

    Page<Peso> findByTutelado_Id(Long id, Pageable paginacao);
}
