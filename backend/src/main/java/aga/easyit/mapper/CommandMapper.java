package aga.easyit.mapper;

import org.mapstruct.Mapper;
import aga.easyit.dto.CommandDTO;
import aga.easyit.model.Command;

@Mapper(componentModel="spring")
public abstract class CommandMapper{
    
    public abstract CommandDTO toDto(Command command);

    public abstract Command toEntity(CommandDTO commandDTO);


    public Command toEntityFromRawString(String rawSyntaxString){
        String[] tokens=rawSyntaxString.trim().split("//s+");
        String firstToken = tokens[0];
        //TODO parsowanie bazy w zaleznosci czy to funkcja w bibliotece czy command w terminalu
        Command parsedCommand = new Command(firstToken, "Parsed command");
        return parsedCommand;
    }
}
