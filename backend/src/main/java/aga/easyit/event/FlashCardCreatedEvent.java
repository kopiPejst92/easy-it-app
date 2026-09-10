package aga.easyit.event;

import java.time.LocalDateTime;

import aga.easyit.model.Command;

public record FlashCardCreatedEvent(
    Long flashCardId,
    String title,
    Command command,
    LocalDateTime createdAt
){};

