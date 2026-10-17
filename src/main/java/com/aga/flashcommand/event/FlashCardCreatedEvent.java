package com.aga.flashcommand.event;

import java.time.LocalDateTime;

import com.aga.flashcommand.model.Command;

public record FlashCardCreatedEvent(
    Long flashCardId,
    String title,
    Command command,
    LocalDateTime createdAt
){};

