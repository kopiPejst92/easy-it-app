package aga.easyit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import aga.easyit.dto.ArgumentDTO;
import aga.easyit.dto.CommandDTO;

@Component
public class CommandParserService {

    public CommandTarget parse(String rawCommand) {
        // Simple mock example processing logic:
        String[] tokens = rawCommand.trim().split("\\s+");
        String baseSyntax = tokens[0]; // e.g. "git" or "mvn"
        

        //TODO: to change
        List<ArgumentDTO> parsedArgs = new ArrayList<>();
        // Iterate through remaining tokens to extract flags/arguments dynamically...
        for(int i = 1; i < tokens.length; i++) {
            if(tokens[i].startsWith("-")) {
                parsedArgs.add(new ArgumentDTO(tokens[i], "Auto-parsed flag"));
            }
        }
        
        CommandDTO commandDTO = new CommandDTO(baseSyntax, null, "Automatically parsed command");
        return new CommandTarget(commandDTO, parsedArgs);
    }
}
