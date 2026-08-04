package aga.easyit.service.parser;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import aga.easyit.dto.ArgumentDTO;
import aga.easyit.dto.CommandDTO;

@Component
public class CLICommandParser implements CommandParser{

    private static final Pattern CLI_PATTERN = Pattern.compile("^[a-zA-Z0-9_-]+(\\s+.*)?$");
    @Override
    public boolean supports(String rawSyntax) {
        String trimmed= rawSyntax.trim();
        return CLI_PATTERN.matcher(trimmed).matches();
    }

    @Override
    public CommandDTO parse(String rawSyntax) {
        if (rawSyntax == null || rawSyntax.isBlank()) {
            throw new IllegalArgumentException("Raw syntax cannot be empty");
        }
        String[] tokens= rawSyntax.split("\\s+");
        List<ArgumentDTO> argumentDTOs = Arrays.stream(tokens).skip(2).map(token-> new ArgumentDTO(null, token, "Parsed argument")).toList();
        CommandDTO parsed=new CommandDTO(null, tokens[1], "Parsed CLI command", argumentDTOs);
        return parsed;
    }

}
