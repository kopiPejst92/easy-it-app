package aga.easyit.mapper;

import org.mapstruct.Mapper;
import aga.easyit.dto.CommandDTO;
import aga.easyit.model.Command;

@Mapper(componentModel="spring")
public abstract class CommandMapper{
    
    public abstract CommandDTO toDto(Command command);

    public abstract Command toEntity(CommandDTO commandDTO);
}
