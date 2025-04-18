package com.facomp.pethub.tutelado.service;

import com.facomp.pethub.configuration.exception.BusinessException;
import com.facomp.pethub.tutelado.domain.dto.request.ConsultaRequest;
import com.facomp.pethub.tutelado.domain.dto.response.ConsultaResponse;
import com.facomp.pethub.tutelado.domain.model.Consulta;
import com.facomp.pethub.tutelado.mapper.ConsultaMapper;
import com.facomp.pethub.tutelado.repository.ConsultaRepository;
import com.facomp.pethub.tutelado.mapper.TuteladoMapper;
import jakarta.persistence.criteria.Predicate;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final TuteladoService tuteladoService;
    private final ConsultaMapper consultaMapper;
    private final TuteladoMapper tuteladoMapper;

    public ConsultaService(ConsultaRepository consultaRepository, TuteladoService tuteladoService, ConsultaMapper consultaMapper, TuteladoMapper tuteladoMapper) {
        this.consultaRepository = consultaRepository;
        this.tuteladoService = tuteladoService;
        this.consultaMapper = consultaMapper;
        this.tuteladoMapper = tuteladoMapper;
    }

    public Page<ConsultaResponse> findConsultaPorTutelado(Long id, Pageable paginacao) {
        Page<Consulta> consultas = consultaRepository.findByTutelado_IdAndConsultaCanceladaIsFalse(id, paginacao);
        return consultas.map(consultaMapper::mapToDto);
    }

    public ConsultaResponse create(@Valid ConsultaRequest consultaRequest) {

        var tutelado = tuteladoService.buscarPorId(consultaRequest.getTuteladoId());

        if (consultaRequest.getDataConsulta().isBefore(LocalDateTime.now())) {
            throw new BusinessException("Data da consulta não pode ser anterior a data atual");
        }

        LocalDateTime inicio = consultaRequest.getDataConsulta();
        LocalDateTime fim = consultaRequest.getDataConsulta().plusHours(2);

        if (consultaRequest.getDuracaoConsulta() != null) {
            fim = consultaRequest.getDataConsulta().plusHours(consultaRequest.getDuracaoConsulta());
        }

        List<Consulta> consultas = consultaRepository.findByDataConsultaBetween(inicio, fim);

        if (!consultas.isEmpty()) {
            throw new BusinessException("Já existe uma consulta marcada para este horário");
        }

        var consulta = consultaMapper.mapToEntity(consultaRequest);

        consulta.setTutelado(tuteladoMapper.mapToEntity(tutelado));

        consulta = consultaRepository.save(consulta);

        return consultaMapper.mapToDto(consulta);
    }

    public ConsultaResponse update(Long idConsulta, @Valid ConsultaRequest consultaRequest) {
        var tutelado = tuteladoService.buscarPorId(consultaRequest.getTuteladoId());
        var consulta = consultaRepository.findById(idConsulta)
                .orElseThrow(() -> new BusinessException("Consulta não encontrada"));

        boolean alterouData = !consulta.getDataConsulta().isEqual(consultaRequest.getDataConsulta());

        if (alterouData && consultaRequest.getDataConsulta().isBefore(LocalDateTime.now())) {
            throw new BusinessException("Data da consulta não pode ser anterior à data atual");
        }

        LocalDateTime inicio = consultaRequest.getDataConsulta();
        LocalDateTime fim = consultaRequest.getDataConsulta().plusHours(2);
        List<Consulta> consultas = consultaRepository.findByDataConsultaBetweenAndIdNot(inicio, fim, idConsulta);

        if (!consultas.isEmpty()) {
            throw new BusinessException("Já existe uma consulta marcada para este horário");
        }

        consultaMapper.updateToEntity(consultaRequest, consulta);

        consulta.setTutelado(tuteladoMapper.mapToEntity(tutelado));

        consulta = consultaRepository.save(consulta);

        return consultaMapper.mapToDto(consulta);
    }

    public void delete(Long idConsulta) {
        var consulta = consultaRepository.findById(idConsulta)
                .orElseThrow(() -> new BusinessException("Consulta não encontrada"));

        consulta.setConsultaCancelada(true);

        consultaRepository.save(consulta);
    }

    public Page<ConsultaResponse> findAll(ConsultaRequest consultaRequest, Pageable paginacao) {
        Specification<Consulta> especificacao = criarEspecificacao(consultaRequest);
        Page<Consulta> pagina = consultaRepository.findAll(especificacao, paginacao);
        return pagina.map(consultaMapper::mapToDto);
    }

    private Specification<Consulta> criarEspecificacao(ConsultaRequest consultaRequest) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (consultaRequest.getDataConsulta() != null) {
                predicates.add(criteriaBuilder.equal(root.get("dataConsulta"), consultaRequest.getDataConsulta()));
            }

            if (consultaRequest.isRetorno()) {
                predicates.add(criteriaBuilder.isTrue(root.get("retorno")));
            }

            if (consultaRequest.getTuteladoId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("tutelado").get("id"), consultaRequest.getTuteladoId()));
            }

            predicates.add(criteriaBuilder.isFalse(root.get("consultaCancelada")));

            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("dataConsulta"), LocalDateTime.now()));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public ConsultaResponse findById(Long idConsulta) {
        var consulta = consultaRepository.findById(idConsulta)
                .orElseThrow(() -> new BusinessException("Consulta não encontrada"));

        return consultaMapper.mapToDto(consulta);
    }
}



