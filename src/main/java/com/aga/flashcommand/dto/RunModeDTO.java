package com.aga.flashcommand.dto;

public record RunModeDTO(
    String name,
    String environment,
    String description,
    CommandDTO commandDTO
) {}
