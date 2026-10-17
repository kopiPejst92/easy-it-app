package aga.easyit.service.parser;

import aga.easyit.dto.CommandDTO;

public interface CommandParser {
    boolean supports(String rawSyntax);
    CommandDTO parse(String r);
}
