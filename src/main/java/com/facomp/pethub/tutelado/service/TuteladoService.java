package com.facomp.pethub.tutelado.service;

import com.facomp.pethub.configuration.exception.RegisterNotFoundException;
import com.facomp.pethub.tutelado.domain.dto.request.TuteladoRequest;
import com.facomp.pethub.tutelado.domain.dto.response.TuteladoResponse;
import com.facomp.pethub.tutelado.domain.model.*;
import com.facomp.pethub.tutelado.mapper.TuteladoMapper;
import com.facomp.pethub.tutelado.repository.*;
import com.facomp.pethub.tutor.repository.TutorRepository;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TuteladoService {

    private static final String VALIDACAO_TUTELADO_NAO_ECONTRADO = "Tutelado não encontrado!";

    private final TuteladoRepository tuteladoRepository;
    private final TuteladoMapper tuteladoMapper;
    private final TuteladoValidator tuteladoValidator;


    public Page<TuteladoResponse> buscarTodos(TuteladoRequest tuteladoDto, Pageable paginacao) {
        Specification<Tutelado> especificacao = criarEspecificacao(tuteladoDto);
        Page<Tutelado> pagina = tuteladoRepository.findAll(especificacao, paginacao);
        return pagina.map(tuteladoMapper::mapToDto);
    }

    private Specification<Tutelado> criarEspecificacao(TuteladoRequest tuteladoDto) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (tuteladoDto.getNome() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")), "%" + tuteladoDto.getNome().toLowerCase() + "%"));
            }

            if (tuteladoDto.getTutor() != null && tuteladoDto.getTutor().getNome() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("tutor").get("nome")), "%" + tuteladoDto.getTutor().getNome().toLowerCase() + "%"));
            }

            predicates.add(criteriaBuilder.isNull(root.get("dataHoraExclusao")));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public TuteladoResponse buscarPorId(Long id) {
        var tutelado = tuteladoRepository.findById(id)
                .orElseThrow(() -> new RegisterNotFoundException(VALIDACAO_TUTELADO_NAO_ECONTRADO));
        return tuteladoMapper.mapToDto(tutelado);
    }

    public TuteladoResponse criar(TuteladoRequest tuteladoDto) {
        var tutelado = tuteladoMapper.mapToEntity(tuteladoDto);
        tuteladoValidator.validarTutelado(tutelado);
        var salvo = tuteladoRepository.save(tutelado);
        return tuteladoMapper.mapToDto(salvo);
    }

    public TuteladoResponse atualizar(Long id, TuteladoResponse tuteladoDto) {
        if (!tuteladoRepository.existsById(id)) {
            throw new RegisterNotFoundException(VALIDACAO_TUTELADO_NAO_ECONTRADO);
        }
        var tutelado = tuteladoMapper.mapToEntity(tuteladoDto);
        tutelado.setId(id);
        var atualizado = tuteladoRepository.save(tutelado);
        return tuteladoMapper.mapToDto(atualizado);
    }

    public void deletar(Long id) {
        var tutelado = tuteladoRepository.findById(id)
                .orElseThrow(() -> new RegisterNotFoundException(VALIDACAO_TUTELADO_NAO_ECONTRADO));
        tutelado.setDataHoraExclusao(LocalDateTime.now());
        tuteladoRepository.save(tutelado);
    }
}
