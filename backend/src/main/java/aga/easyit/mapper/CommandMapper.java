package aga.easyit.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import aga.easyit.dto.CommandDTO;
import aga.easyit.model.Command;

@Mapper(componentModel="spring", uses = {ArgumentMapper.class})
public interface CommandMapper { 
    CommandDTO toDto(Command command);

    List<CommandDTO> toDtoList(List<Command> commands);

    Command toEntity(CommandDTO commandDto);
}
