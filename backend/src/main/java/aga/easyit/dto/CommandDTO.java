package aga.easyit.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;

public record CommandDTO(
    @NotBlank(message="Command syntax cannot be empty")
    String syntax,
    String runMode,
    String description
) {}
