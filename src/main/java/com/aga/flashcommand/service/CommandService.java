package com.aga.flashcommand.service;

import org.springframework.stereotype.Service;

import com.aga.flashcommand.dto.CommandDTO;
import com.aga.flashcommand.mapper.CommandMapper;
import com.aga.flashcommand.model.Command;
import com.aga.flashcommand.repo.CommandRepository;
import com.aga.flashcommand.service.parser.MasterCommandParser;

@Service
public class CommandService{
    private final CommandRepository commandRepository;
    private final CommandMapper commandMapper;
    private final MasterCommandParser commandParser;

    public CommandService(CommandRepository commandRepository, CommandMapper commandMapper, MasterCommandParser commandParser){
        this.commandRepository=commandRepository;
        this.commandMapper=commandMapper;
        this.commandParser=commandParser;
    }

    public Command getOrCreateCommand(String rawSyntax, CommandDTO commandDTO){
        CommandDTO dto = (rawSyntax != null && !rawSyntax.isBlank())
                ? commandParser.parse(rawSyntax)
                : commandDTO;
        if (dto == null) {
            throw new IllegalArgumentException("There is no command found");
        }
        return commandRepository.findByToolAndSyntax(dto.tool(), dto.syntax())
                .orElseGet(() -> {
                    Command newCommand = commandMapper.toEntity(dto);
                    return commandRepository.save(newCommand);
                });
    }
}
