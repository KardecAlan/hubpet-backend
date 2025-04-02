package com.facomp.pethub.usuario.mapper;

import com.facomp.pethub.usuario.domain.model.Cargo;
import com.facomp.pethub.usuario.domain.model.dto.CargoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CargoMapper {

    @Mapping(target = "cargo", source = "cargo")
    CargoDto mapToDto(Cargo cargo);

    @Mapping(target = "cargo", source = "cargo")
    List<CargoDto> mapToDtoList(List<Cargo> cargo);

    default List<String> mapTipoCargoList(List<Cargo> cargos) {
        return cargos.stream().map(cargo -> cargo.getCargo().name()).toList();
    }

}
