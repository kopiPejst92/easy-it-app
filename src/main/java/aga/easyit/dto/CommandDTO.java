package aga.easyit.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;

public record CommandDTO(
    @NotBlank(message="Command cannot be empty")
    String base,
    List<ArgumentDTO> ArgumentDTO,
    String runMode
) {}
