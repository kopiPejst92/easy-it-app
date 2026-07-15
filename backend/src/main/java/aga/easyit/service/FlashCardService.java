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
    
    public FlashCardService(FlashCardRepository flashCardRepository, CommandService commandService) {
        this.flashCardRepository = flashCardRepository;
        this.commandService = commandService;
    }

    @Transactional
    public FlashCard createFlashCard(FlashCardDTO fcDTO) {
        

        // // Scenario: Parse raw string string if provided
        if (fcDTO.rawCommandString() != null && !fcDTO.rawCommandString().isBlank()) {
            commandService.createCommandFromRawSyntax(fcDTO.rawCommandString());
        }
        // } else {
            
        // }

        FlashCard flashCard = new FlashCard(fcDTO.title(), );
        
        // return flashCardRepository.save(flashCard);
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

record CommandTarget() {}