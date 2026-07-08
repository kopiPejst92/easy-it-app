package aga.easyit.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;

public record FlashCardDTO(
    @NotBlank String  title,
    // TODO: czy nie lepiej command_id? 
    CommandDTO commandDTO,
    String rawCommandString,
    List<ArgumentDTO> argumentDTOs,
    List<String> problemTags
) {}
