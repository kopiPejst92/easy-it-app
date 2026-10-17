package com.aga.flashcommand.service.parser;

import com.aga.flashcommand.dto.CommandDTO;

public interface CommandParser {
    boolean supports(String rawSyntax);
    CommandDTO parse(String r);
}
