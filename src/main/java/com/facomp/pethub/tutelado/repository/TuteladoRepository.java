package com.facomp.pethub.tutelado.repository;

import com.facomp.pethub.tutelado.domain.model.Tutelado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TuteladoRepository extends JpaRepository<Tutelado, Long>, JpaSpecificationExecutor<Tutelado> {
}
