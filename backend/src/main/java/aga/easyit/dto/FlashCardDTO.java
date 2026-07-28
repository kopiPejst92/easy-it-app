package aga.easyit.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;

public record FlashCardDTO(
    Long id,
    @NotBlank(message = "Title cannot be empty")
    String  title,
    CommandDTO command,
    String rawCommandString,
    List<String> problemTags
) {}
