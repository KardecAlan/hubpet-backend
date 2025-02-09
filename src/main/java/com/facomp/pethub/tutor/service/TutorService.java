package com.facomp.pethub.tutor.service;

import com.facomp.pethub.configuration.exception.RegisterNotFoundException;
import com.facomp.pethub.tutor.domain.dto.request.TutorRequest;
import com.facomp.pethub.tutor.domain.dto.response.TutorResponse;
import com.facomp.pethub.tutor.domain.model.Tutor;
import com.facomp.pethub.tutor.mapper.TutorMapper;
import com.facomp.pethub.tutor.repository.TutorRepository;
import jakarta.persistence.criteria.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service("tutorService")
public class TutorService {

    private final TutorRepository tutorRepository;
    private final TutorMapper tutorMapper;

    public TutorService(TutorRepository tutorRepository, TutorMapper tutorMapper) {
        this.tutorRepository = tutorRepository;
        this.tutorMapper = tutorMapper;
    }

    public Page<TutorResponse> buscarTodos(TutorRequest tutorDto, Pageable paginacao) {
        Specification<Tutor> especificacao = criarEspecificacao(tutorDto);
        Page<Tutor> pagina = tutorRepository.findAll(especificacao, paginacao);
        return pagina.map(tutorMapper::mapToDto);
    }

    private Specification<Tutor> criarEspecificacao(TutorRequest tutorDto) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (tutorDto.getNome() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")), "%" + tutorDto.getNome().toLowerCase() + "%"));
            }
            if (tutorDto.getCpf() != null) {
                predicates.add(criteriaBuilder.equal(root.get("cpf"), tutorDto.getCpf()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public TutorResponse buscarPorId(Long id) {
        Tutor tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new RegisterNotFoundException("Tutor não encontrado!"));
        return tutorMapper.mapToDto(tutor);
    }

    public TutorResponse criar(TutorRequest tutorDto) {
        Tutor tutor = tutorMapper.mapToEntity(tutorDto);
        tutor = tutorRepository.save(tutor);
        return tutorMapper.mapToDto(tutor);
    }

    public TutorResponse atualizar(Long id, TutorResponse tutorDto) {
        if (!tutorRepository.existsById(id)) {
            throw new RegisterNotFoundException("Tutor não encontrado!");
        }
        Tutor tutor = tutorMapper.mapToEntity(tutorDto);
        tutor.setId(id);
        tutor = tutorRepository.save(tutor);
        return tutorMapper.mapToDto(tutor);
    }

    public void deletar(Long id) {
        Tutor tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new RegisterNotFoundException("Tutor não encontrado!"));
        tutor.setDataHoraExclusao(LocalDateTime.now());
        tutorRepository.save(tutor);
    }
}
