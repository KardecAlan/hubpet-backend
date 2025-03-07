package com.facomp.pethub.tutelado.mapper;


import com.facomp.pethub.tutelado.domain.dto.request.VacinaRequest;
import com.facomp.pethub.tutelado.domain.dto.response.VacinaResponse;
import com.facomp.pethub.tutelado.domain.model.Vacina;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface VacinaMapper {

    VacinaResponse mapToDto(Vacina vacina);

    Vacina mapToEntity(VacinaRequest vacinaRequest);

    @Mapping(target = "id", ignore = true)
    void updateToEntity(VacinaRequest vacinaRequest, @MappingTarget Vacina vacina);
}
