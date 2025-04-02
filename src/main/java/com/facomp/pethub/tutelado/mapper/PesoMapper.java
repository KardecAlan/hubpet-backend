package com.facomp.pethub.tutelado.mapper;


import com.facomp.pethub.tutelado.domain.dto.request.PesoRequest;
import com.facomp.pethub.tutelado.domain.dto.response.PesoResponse;
import com.facomp.pethub.tutelado.domain.model.Peso;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PesoMapper {

    PesoResponse mapToDto(Peso peso);

    Peso mapToEntity(PesoRequest pesoRequest);

    @Mapping(target = "id", ignore = true)
    void updateToEntity(PesoRequest request, @MappingTarget Peso consulta);
}
