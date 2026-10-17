package com.aga.flashcommand.mapper;

import java.util.List;
import org.mapstruct.Mapper;

import com.aga.flashcommand.dto.CommandDTO;
import com.aga.flashcommand.model.Command;

@Mapper(componentModel="spring", uses = {ArgumentMapper.class})
public interface CommandMapper { 
    CommandDTO toDto(Command command);

    List<CommandDTO> toDtoList(List<Command> commands);

    Command toEntity(CommandDTO commandDto);
}
