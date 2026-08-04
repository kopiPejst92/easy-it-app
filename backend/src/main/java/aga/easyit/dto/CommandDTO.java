package aga.easyit.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;

public record CommandDTO(
    Long id,
    String tool,
    @NotBlank(message="Command syntax cannot be empty")
    String syntax,
    // RunModeDTO runModeDTO,
    String description,
    List<ArgumentDTO> arguments
) {}
