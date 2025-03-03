package com.facomp.pethub.peso.service;

import com.facomp.pethub.peso.domain.dto.request.PesoRequest;
import com.facomp.pethub.peso.domain.dto.response.PesoResponse;
import com.facomp.pethub.peso.domain.model.Peso;
import com.facomp.pethub.peso.mapper.PesoMapper;
import com.facomp.pethub.peso.repository.PesoRepository;
import com.facomp.pethub.tutelado.service.TuteladoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class PesoService {
    
    private final PesoRepository pesoRepository;
    private final TuteladoService tuteladoService;
    private final PesoMapper pesoMapper;

    public PesoService(PesoRepository pesoRepository, TuteladoService tuteladoService, PesoMapper pesoMapper) {
        this.pesoRepository = pesoRepository;
        this.tuteladoService = tuteladoService;
        this.pesoMapper = pesoMapper;
    }



    public PesoResponse create(Long id, @Valid PesoRequest pesoRequest) {
        var tutelado = tuteladoService.buscarPorId(id);
        var peso = pesoMapper.mapToEntity(pesoRequest, tutelado);
        var pesoSaved = pesoRepository.save(peso);
        return pesoMapper.mapToDto(pesoSaved);
    }


    public Page<PesoResponse> findPesoPorTutelado(Long id, Pageable paginacao) {
    }
}
