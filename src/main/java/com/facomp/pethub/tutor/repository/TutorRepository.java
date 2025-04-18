package com.facomp.pethub.tutor.repository;

import com.facomp.pethub.tutor.domain.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long>, JpaSpecificationExecutor<Tutor> {


    List<Tutor> findAllByDataHoraExclusaoIsNull();
}
