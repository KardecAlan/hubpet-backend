package com.facomp.pethub.peso.mapper;


import com.facomp.pethub.peso.domain.dto.request.PesoRequest;
import com.facomp.pethub.peso.domain.dto.response.PesoResponse;
import com.facomp.pethub.peso.domain.model.Peso;
import com.facomp.pethub.tutelado.domain.dto.response.TuteladoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PesoMapper {

    PesoResponse mapToDto(Peso peso);

    Peso mapToEntity(PesoRequest pesoRequest, TuteladoResponse tutelado);
}
