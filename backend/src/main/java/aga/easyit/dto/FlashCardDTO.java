package aga.easyit.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;

public record FlashCardDTO(
    @NotBlank String  title,
    CommandDTO commandDTO,
    String rawCommandString,
    List<ArgumentDTO> argumentDTOs,
    List<String> problemTags
) {}
