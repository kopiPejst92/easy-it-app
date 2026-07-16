package aga.easyit.service;

import aga.easyit.repo.FlashCardRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;
import aga.easyit.dto.FlashCardDTO;
import aga.easyit.exception.CardNotFoundException;
// import aga.easyit.mapper.ArgumentMapper;
import aga.easyit.model.Command;
import aga.easyit.model.FlashCard;

@Service
public class FlashCardService {
    private final FlashCardRepository flashCardRepository;
    private final CommandService commandService;
    // private final ArgumentMapper argumentMapper;
    
    // public FlashCardService(FlashCardRepository flashCardRepository, CommandService commandService, ArgumentMapper argumentMapper) {
    public FlashCardService(FlashCardRepository flashCardRepository, CommandService commandService) {
        this.flashCardRepository = flashCardRepository;
        this.commandService = commandService;
        // this.argumentMapper=argumentMapper;
    }

    @Transactional
    public FlashCard createFlashCard(FlashCardDTO fcDTO) {
        // Command command;
        //Step I Create command
        //Scenario I: With commandDTO 
        Command command = commandService.getOrCreateCommand(fcDTO.commandDTO());

        // if (fcDTO.rawCommandString() != null && !fcDTO.rawCommandString().isBlank()) {
            
        // }   
        // else{
        //     command=commandService.getOrCreateCommand(fcDTO.commandDTO(), fcDTO.argumentDTOs());
        // }
        // //add part with argument
        FlashCard flashCard = new FlashCard(fcDTO.title(), command);
        
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

record CommandTarget() {}