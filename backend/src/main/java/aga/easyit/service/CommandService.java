package aga.easyit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import aga.easyit.dto.ArgumentDTO;
import aga.easyit.dto.CommandDTO;
import aga.easyit.mapper.ArgumentMapper;
import aga.easyit.mapper.CommandMapper;
import aga.easyit.model.Argument;
import aga.easyit.model.Command;
import aga.easyit.repo.CommandRepository;

@Service
public class CommandService{
    private final CommandRepository commandRepository;
    private final CommandMapper commandMapper;
    private final ArgumentMapper argumentMapper;

    public CommandService(CommandRepository commandRepository, CommandMapper commandMapper, ArgumentMapper argumentMapper){
        this.commandRepository=commandRepository;
        this.commandMapper=commandMapper;
        this.argumentMapper=argumentMapper;
    }
    
    public Command getOrCreateCommand(CommandDTO commandDTO, List<ArgumentDTO> lArgumentDTOs){
       return commandRepository.findCommandBySyntax(commandDTO.syntax()).map(existingCommand -> { 
        if(lArgumentDTOs!=null && !lArgumentDTOs.isEmpty()){
            updateCommandArguments(existingCommand, lArgumentDTOs);
        }
        return existingCommand;
       }).orElseGet(() ->{ 
        Command newCom= commandMapper.toEntity(commandDTO);
        if(lArgumentDTOs!=null && !lArgumentDTOs.isEmpty()){
            updateCommandArguments(newCom, lArgumentDTOs);
        }
        return this.commandRepository.save(newCom);});
    }

    private void updateCommandArguments(Command command, List<ArgumentDTO> lArgumentDTOs) {
        List<Argument> arguments = lArgumentDTOs.stream()
            .map(dto -> {
                Argument arg = argumentMapper.toEntity(dto);
                arg.setCommand(command);
                return arg;
            }).toList();
        
        if (command.getArgumentsList() == null) {
            command.setArgumentsList(arguments);
        } else {
            command.getArgumentsList().addAll(arguments);
        }

    }
}
