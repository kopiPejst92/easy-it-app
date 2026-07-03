package aga.easyit.dto;

import java.util.List;

public record FlashCardDTO(
    String  title,
    // TODO czy nie lepiej plaskie Dto? czyli zamiast command id
    CommandDTO commandDTO,
    List<String> problemTags
) {}
