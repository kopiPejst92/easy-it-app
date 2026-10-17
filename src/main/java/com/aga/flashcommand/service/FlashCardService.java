package com.aga.flashcommand.service;

import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

import com.aga.flashcommand.dto.FlashCardDTO;
import com.aga.flashcommand.event.FlashCardCreatedEvent;
import com.aga.flashcommand.exception.CardNotFoundException;
import com.aga.flashcommand.mapper.FlashCardMapper;
import com.aga.flashcommand.model.Command;
import com.aga.flashcommand.model.FlashCard;
import com.aga.flashcommand.repo.FlashCardRepository;

import org.springframework.kafka.core.KafkaTemplate;

@Service
public class FlashCardService {
    private final FlashCardRepository flashCardRepository;
    private final FlashCardMapper flashCardMapper;
    private final CommandService commandService;
    private final KafkaTemplate<String, FlashCardCreatedEvent> kafkaTemplate;
    
    public FlashCardService(FlashCardRepository flashCardRepository, FlashCardMapper flashCardMapper, CommandService commandService, KafkaTemplate<String, FlashCardCreatedEvent> kafkaTemplate) {
        this.flashCardRepository = flashCardRepository;
        this.flashCardMapper=flashCardMapper;
        this.commandService = commandService;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Transactional
    public FlashCardDTO createFlashCard(FlashCardDTO fcDTO) {
        Command command = commandService.getOrCreateCommand(fcDTO.rawCommandString(), fcDTO.command());
        FlashCard flashCard = flashCardMapper.toEntity(fcDTO);
        if(flashCard.getCommand()==null){
            flashCard.setCommand(command);
        }
        FlashCard saved = flashCardRepository.save(flashCard);
        FlashCardCreatedEvent event = new FlashCardCreatedEvent(
            saved.getId(),
            saved.getTitle(),
            saved.getCommand(),
            LocalDateTime.now()
        );
        kafkaTemplate.send("flashcard-created-topic", saved.getId().toString(), event);
        return flashCardMapper.toDto(saved);  
    }

    @Transactional
    public FlashCardDTO updateFlashCard(FlashCardDTO flashCardDTO){
        FlashCard toUpdate=flashCardRepository.findById(flashCardDTO.id()).orElseThrow(() -> new CardNotFoundException("Flash card is not found"));
        Command command = commandService.getOrCreateCommand(flashCardDTO.rawCommandString(), flashCardDTO.command());
        toUpdate.setCommand(command);
        toUpdate.setTitle(flashCardDTO.title());
        toUpdate.setProblemTags(flashCardDTO.problemTags());
        return flashCardMapper.toDto(toUpdate);
    }

    public List<FlashCardDTO> findAllFlashCards(){
        return flashCardMapper.toDtoList(flashCardRepository.findAll());
    }

    public FlashCardDTO findFlashCardById(Long id){
        FlashCard found= flashCardRepository.findById(id).orElseThrow(() -> new CardNotFoundException("Flash card"+id+" is not found"));
        return flashCardMapper.toDto(found);
    }

    public void deleteFlashCard(Long id){
        flashCardRepository.deleteFlashCardById(id);
    }
}
