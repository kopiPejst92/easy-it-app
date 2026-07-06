package aga.easyit.dto;

import java.util.List;

public record FlashCardDTO(
    String  title,
    // TODO: czy nie lepiej command_id? 
    CommandDTO commandDTO,
    List<String> problemTags
) {}
