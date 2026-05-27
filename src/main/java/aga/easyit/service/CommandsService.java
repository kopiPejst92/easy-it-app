package aga.easyit.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aga.easyit.model.Command;
import aga.easyit.repo.CommandsRepository;

@Service
public class CommandsService {
    private final CommandsRepository commandsRepository;

    @Autowired
    public CommandsService(CommandsRepository commandsRepository){
        this.commandsRepository=commandsRepository;
    }

    public Command addCommand(Command command){
        command.setName("git");
        return commandsRepository.save(command);
    }

    public List<Command> findAllCommands(){
        return commandsRepository.findAll();
    }
}
