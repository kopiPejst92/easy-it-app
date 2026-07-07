package aga.easyit.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;

public record FlashCardDTO(
    String  title,
    // TODO: czy nie lepiej command_id? 
    @NotBlank
    CommandDTO commandDTO,
    List<String> problemTags
) {}
