package aga.easyit.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import aga.easyit.dto.ArgumentDTO;
import aga.easyit.model.Argument;

@Mapper(componentModel="spring")
    public interface ArgumentMapper {
        ArgumentDTO toDto(Argument argument);

       @Mapping(target = "id", ignore = true)
       @Mapping(target = "command", ignore = true)
       Argument toEntity(ArgumentDTO argumentDTO);

       List<Argument> toEntityList(List<ArgumentDTO> argumetDtos);
}
