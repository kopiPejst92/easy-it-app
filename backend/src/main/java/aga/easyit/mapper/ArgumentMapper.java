package aga.easyit.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import aga.easyit.dto.ArgumentDTO;
import aga.easyit.model.Argument;

@Mapper(componentModel="spring", uses={CommandMapper.class})
    public interface ArgumentMapper {
        ArgumentDTO toDto(Argument argument);

        Argument toEntity(ArgumentDTO argumentDTO);

        List<Argument> toEntityList(List<ArgumentDTO> dtos);
}
