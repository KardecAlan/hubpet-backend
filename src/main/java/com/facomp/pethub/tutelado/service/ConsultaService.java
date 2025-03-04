package com.facomp.pethub.tutelado.service;

import com.facomp.pethub.configuration.exception.BusinessException;
import com.facomp.pethub.tutelado.domain.dto.request.ConsultaRequest;
import com.facomp.pethub.tutelado.domain.dto.response.ConsultaResponse;
import com.facomp.pethub.tutelado.domain.model.Consulta;
import com.facomp.pethub.tutelado.mapper.ConsultaMapper;
import com.facomp.pethub.tutelado.repository.ConsultaRepository;
import com.facomp.pethub.tutelado.mapper.TuteladoMapper;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public Page<ConsultaResponse> findPesoPorTutelado(Long id, Pageable paginacao) {
        Page<Consulta> consultas = consultaRepository.findByTutelado_Id(id, paginacao);
        return consultas.map(consultaMapper::mapToDto);
    }

    public ConsultaResponse create(Long id, @Valid ConsultaRequest consultaRequest) {

        var tutelado = tuteladoService.buscarPorId(id);

        if (consultaRequest.getDataConsulta().isBefore(LocalDateTime.now())) {
            throw new BusinessException("Data da consulta não pode ser anterior a data atual");
        }

        LocalDateTime inicio = consultaRequest.getDataConsulta();
        LocalDateTime fim = inicio.plusHours(2);
        List<Consulta> consultas = consultaRepository.findByDataConsultaBetween(inicio.minusHours(2), fim);

        if (!consultas.isEmpty()) {
            throw new BusinessException("Já existe uma consulta marcada para este horário");
        }

        var consulta = consultaMapper.mapToEntity(consultaRequest);

        consulta.setTutelado(tuteladoMapper.mapToEntity(tutelado));

        consulta = consultaRepository.save(consulta);

        return consultaMapper.mapToDto(consulta);
    }

    public ConsultaResponse update(Long idTutelado, Long idConsulta, @Valid ConsultaRequest consultaRequest) {
        var tutelado = tuteladoService.buscarPorId(idTutelado);
        var consulta = consultaRepository.findById(idConsulta)
                .orElseThrow(() -> new BusinessException("Consulta não encontrada"));

        boolean alterouData = !consulta.getDataConsulta().isEqual(consultaRequest.getDataConsulta());

        if (alterouData && consultaRequest.getDataConsulta().isBefore(LocalDateTime.now())) {
            throw new BusinessException("Data da consulta não pode ser anterior à data atual");
        }

        LocalDateTime inicio = consultaRequest.getDataConsulta();
        LocalDateTime fim = inicio.plusHours(2);
        List<Consulta> consultas = consultaRepository.findByDataConsultaBetweenAndIdNot(inicio.minusHours(2), fim, idConsulta);

        if (!consultas.isEmpty()) {
            throw new BusinessException("Já existe uma consulta marcada para este horário");
        }

        consultaMapper.updateToEntity(consultaRequest, consulta);

        consulta.setTutelado(tuteladoMapper.mapToEntity(tutelado));

        consulta = consultaRepository.save(consulta);

        return consultaMapper.mapToDto(consulta);
    }
}



