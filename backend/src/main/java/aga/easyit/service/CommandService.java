package aga.easyit.service;

import org.springframework.stereotype.Service;

import aga.easyit.dto.CommandDTO;
import aga.easyit.model.Command;
import aga.easyit.repo.CommandRepository;

@Service
public class CommandService{
    private final CommandRepository commandRepository;

    public CommandService(CommandRepository commandRepository){
        this.commandRepository=commandRepository;
    }
    
    public Command getOrCreateCommand(CommandDTO commandDTO){
       return commandRepository.findCommandByBase(commandDTO.base()).orElseGet(() ->
       { 
        Command newCom = new Command(commandDTO.base(), "here add some explanation to the command e.g. initializes respository in Git");
        return newCom;
        });
    }
    
}
