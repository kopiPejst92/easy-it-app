package aga.easyit.dto;

import java.util.List;

public record FlashCardDTO(
    String  title,
    CommandDTO commandDTO,
    List<String> problemTags
) {}
