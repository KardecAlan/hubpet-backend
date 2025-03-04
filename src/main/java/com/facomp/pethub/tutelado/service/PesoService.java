package com.facomp.pethub.tutelado.service;

import com.facomp.pethub.configuration.exception.RegisterNotFoundException;
import com.facomp.pethub.tutelado.domain.dto.request.PesoRequest;
import com.facomp.pethub.tutelado.domain.dto.response.PesoResponse;
import com.facomp.pethub.tutelado.domain.model.Peso;
import com.facomp.pethub.tutelado.mapper.PesoMapper;
import com.facomp.pethub.tutelado.repository.PesoRepository;
import com.facomp.pethub.tutelado.mapper.TuteladoMapper;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PesoService {

    private static final String VALIDACAO_PESO_NAO_ECONTRADO = "Peso não encontrado!";
    
    private final PesoRepository pesoRepository;
    private final TuteladoService tuteladoService;
    private final PesoMapper pesoMapper;
    private final TuteladoMapper tuteladoMapper;

    public PesoService(PesoRepository pesoRepository, TuteladoService tuteladoService, PesoMapper pesoMapper, TuteladoMapper tuteladoMapper) {
        this.pesoRepository = pesoRepository;
        this.tuteladoService = tuteladoService;
        this.pesoMapper = pesoMapper;
        this.tuteladoMapper = tuteladoMapper;
    }

    public Page<PesoResponse> findPesoPorTutelado(Long id, Pageable paginacao) {
        Page<Peso> pesos = pesoRepository.findByTutelado_Id(id, paginacao);
        return pesos.map(pesoMapper::mapToDto);
    }

    public PesoResponse findById(Long idTutelado, Long idPeso) {

        var peso = pesoRepository.findByIdAndTutelado_Id(idPeso, idTutelado)
                .orElseThrow(() -> new RegisterNotFoundException(VALIDACAO_PESO_NAO_ECONTRADO));

        return pesoMapper.mapToDto(peso);
    }

    public PesoResponse create(Long id, @Valid PesoRequest pesoRequest) {
        var tutelado = tuteladoService.buscarPorId(id);
        var peso = pesoMapper.mapToEntity(pesoRequest);
        peso.setTutelado(tuteladoMapper.mapToEntity(tutelado));
        peso = pesoRepository.save(peso);
        return pesoMapper.mapToDto(peso);
    }


    public PesoResponse update(Long idTutelado, Long idPeso, @Valid PesoRequest pesoRequest) {
        var tutelado = tuteladoService.buscarPorId(idTutelado);
        var peso = pesoRepository.findByIdAndTutelado_Id(idPeso, idTutelado)
                .orElseThrow(() -> new RegisterNotFoundException(VALIDACAO_PESO_NAO_ECONTRADO));
        pesoMapper.updateToEntity(pesoRequest, peso);
        peso.setTutelado(tuteladoMapper.mapToEntity(tutelado));
        peso = pesoRepository.save(peso);
        return pesoMapper.mapToDto(peso);
    }

    public void delete(Long idTutelado, Long idPeso) {
        var peso = pesoRepository.findByIdAndTutelado_Id(idPeso, idTutelado)
                .orElseThrow(() -> new RegisterNotFoundException(VALIDACAO_PESO_NAO_ECONTRADO));
        pesoRepository.delete(peso);
    }

}



