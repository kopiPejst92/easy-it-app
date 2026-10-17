package com.aga.flashcommand.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.aga.flashcommand.dto.ArgumentDTO;
import com.aga.flashcommand.model.Argument;

@Mapper(componentModel="spring")
    public interface ArgumentMapper {
        ArgumentDTO toDto(Argument argument);

       Argument toEntity(ArgumentDTO argumentDTO);

       List<Argument> toEntityList(List<ArgumentDTO> argumetDtos);
}
