package com.facomp.pethub.tutelado.service;

import com.facomp.pethub.configuration.exception.RegisterNotFoundException;
import com.facomp.pethub.tutelado.domain.dto.request.VacinaRequest;
import com.facomp.pethub.tutelado.domain.dto.response.VacinaResponse;
import com.facomp.pethub.tutelado.domain.model.Vacina;
import com.facomp.pethub.tutelado.mapper.TuteladoMapper;
import com.facomp.pethub.tutelado.mapper.VacinaMapper;
import com.facomp.pethub.tutelado.repository.VacinaRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VacinaService {

    private static final String VALIDACAO_PESO_NAO_ECONTRADO = "Vacina não encontrado!";

    private final VacinaRepository vacinaRepository;
    private final TuteladoService tuteladoService;
    private final VacinaMapper vacinaMapper;
    private final TuteladoMapper tuteladoMapper;

    public VacinaService(VacinaRepository vacinaRepository, TuteladoService tuteladoService, VacinaMapper vacinaMapper, TuteladoMapper tuteladoMapper) {
        this.vacinaRepository = vacinaRepository;
        this.tuteladoService = tuteladoService;
        this.vacinaMapper = vacinaMapper;
        this.tuteladoMapper = tuteladoMapper;
    }

    public Page<VacinaResponse> findVacinaPorTutelado(Long id, Pageable paginacao) {
        Page<Vacina> pesos = vacinaRepository.findByTutelado_Id(id, paginacao);
        return pesos.map(vacinaMapper::mapToDto);
    }

    public VacinaResponse findById(Long idTutelado, Long idVacina) {

        var vacina = vacinaRepository.findByIdAndTutelado_Id(idVacina, idTutelado)
                .orElseThrow(() -> new RegisterNotFoundException(VALIDACAO_PESO_NAO_ECONTRADO));

        return vacinaMapper.mapToDto(vacina);
    }

    public VacinaResponse create(Long id, @Valid VacinaRequest vacinaRequest) {
        var tutelado = tuteladoService.buscarPorId(id);
        var vacina = vacinaMapper.mapToEntity(vacinaRequest);
        vacina.setTutelado(tuteladoMapper.mapToEntity(tutelado));
        vacina = vacinaRepository.save(vacina);
        return vacinaMapper.mapToDto(vacina);
    }


    public VacinaResponse update(Long idTutelado, Long idVacina, @Valid VacinaRequest vacinaRequest) {
        var tutelado = tuteladoService.buscarPorId(idTutelado);
        var vacina = vacinaRepository.findByIdAndTutelado_Id(idVacina, idTutelado)
                .orElseThrow(() -> new RegisterNotFoundException(VALIDACAO_PESO_NAO_ECONTRADO));
        vacinaMapper.updateToEntity(vacinaRequest, vacina);
        vacina.setTutelado(tuteladoMapper.mapToEntity(tutelado));
        vacina = vacinaRepository.save(vacina);
        return vacinaMapper.mapToDto(vacina);
    }

    public void delete(Long idTutelado, Long idVacina) {
        var vacina = vacinaRepository.findByIdAndTutelado_Id(idVacina, idTutelado)
                .orElseThrow(() -> new RegisterNotFoundException(VALIDACAO_PESO_NAO_ECONTRADO));
        vacinaRepository.delete(vacina);
    }

}



