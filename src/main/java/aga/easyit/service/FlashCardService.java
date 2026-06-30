package aga.easyit.service;

import aga.easyit.repo.FlashCardRepository;
import java.util.List;
import org.springframework.stereotype.Service;

import aga.easyit.dto.CommandDTO;
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

    public FlashCard createFlashCard(CommandDTO commandDTO){
        Command createdCom= commandService.getOrCreateCommand(commandDTO);
        FlashCard flashCard= new FlashCard("Clear", createdCom);
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
