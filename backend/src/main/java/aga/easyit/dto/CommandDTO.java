package aga.easyit.dto;

import jakarta.validation.constraints.NotBlank;

public record CommandDTO(
    @NotBlank(message="Command syntax cannot be empty")
    String syntax,
    RunModeDTO runModeDTO,
    String description
) {}
