package aga.easyit.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;

public record CommandDTO(
    @NotBlank(message="Command cannot be empty")
    String syntax,
    List<ArgumentDTO> argumentDTOs,
    String runMode
) {}
