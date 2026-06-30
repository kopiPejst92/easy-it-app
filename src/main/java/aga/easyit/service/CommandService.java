package aga.easyit.service;

import com.jetbrains.exported.JBRApi.Service;

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
        return new Command("clear", "This is usually CLI instruction which clears the interface.");
    }
    
}
