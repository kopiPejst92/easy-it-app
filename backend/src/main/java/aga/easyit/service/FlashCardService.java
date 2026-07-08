package aga.easyit.service;

import aga.easyit.repo.FlashCardRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import org.springframework.stereotype.Service;

import aga.easyit.dto.ArgumentDTO;
import aga.easyit.dto.CommandDTO;
import aga.easyit.dto.FlashCardDTO;
import aga.easyit.exception.CardNotFoundException;
import aga.easyit.model.Command;
import aga.easyit.model.FlashCard;

@Service
public class FlashCardService {
    private final FlashCardRepository flashCardRepository;
    private final CommandService commandService;
    private final CommandParserService commandParser; 

    
    public FlashCardService(FlashCardRepository flashCardRepository, CommandService commandService, CommandParserService commandParser) {
        this.flashCardRepository = flashCardRepository;
        this.commandService = commandService;
        this.commandParser=commandParser;
    }

    @Transactional
    public FlashCard createFlashCard(FlashCardDTO dto) {
        CommandTarget target;

        // Scenario: Parse raw string string if provided
        if (dto.rawCommandString() != null && !dto.rawCommandString().isBlank()) {
            target = commandParser.parse(dto.rawCommandString());
        } else {
            target = new CommandTarget(dto.commandDTO(), dto.argumentDTOs());
        }

        Command command = commandService.getOrCreateCommand(target.commandDTO(), target.argumentDTOs());

        FlashCard flashCard = new FlashCard(dto.title(), command);
        
        return flashCardRepository.save(flashCard);
    }

    public FlashCard updateFlashCard(FlashCard flashCard){
        return flashCardRepository.save(flashCard);
    }

    public List<FlashCard> findAllFlashCards(){
        return flashCardRepository.findAll();
    }

    public FlashCard findFlashCardById(Long id){
        return flashCardRepository.findFlashCardById(id).orElseThrow(() ->new CardNotFoundException("Flash card"+id+" is not found"));
    }

    public void deleteFlashCard(Long id){
        flashCardRepository.deleteFlashCardById(id);
    }
}

record CommandTarget(CommandDTO commandDTO, List<ArgumentDTO> argumentDTOs) {}