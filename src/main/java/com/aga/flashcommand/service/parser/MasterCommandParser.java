package com.aga.flashcommand.service.parser;

import java.util.List;

import org.springframework.stereotype.Component;

import com.aga.flashcommand.dto.CommandDTO;

@Component
public class MasterCommandParser {
    private final List<CommandParser> parsers;

    public MasterCommandParser(List<CommandParser> parsers) {
        this.parsers = parsers;
    }

    public CommandDTO parse(String rawString) {
        String trimmed = rawString.trim();

        return parsers.stream()
                .filter(strategy -> strategy.supports(trimmed)) 
                .findFirst()
                .map(strategy -> strategy.parse(trimmed))
                .orElseThrow(() -> new IllegalArgumentException("Command not: " + rawString));
    }
}
