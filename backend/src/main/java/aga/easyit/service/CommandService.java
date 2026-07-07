package aga.easyit.service;

import org.springframework.stereotype.Service;

import aga.easyit.dto.CommandDTO;
import aga.easyit.mapper.CommandMapper;
import aga.easyit.model.Command;
import aga.easyit.repo.CommandRepository;

@Service
public class CommandService{
    private final CommandRepository commandRepository;
    private final CommandMapper commandMapper;

    public CommandService(CommandRepository commandRepository, CommandMapper commandMapper){
        this.commandRepository=commandRepository;
        this.commandMapper=commandMapper;
    }
    
    public Command getOrCreateCommand(CommandDTO commandDTO){
       return commandRepository.findCommandByBase(commandDTO.base()).orElseGet(() ->
       { 
        Command newCom = commandMapper.toEntity(commandDTO);
        //date of update
        return this.commandRepository.save(newCom);
        });
    }
    
}
