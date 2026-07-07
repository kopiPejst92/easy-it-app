package aga.easyit.service;

import aga.easyit.repo.FlashCardRepository;
import java.util.List;
import org.springframework.stereotype.Service;

import aga.easyit.dto.CommandDTO;
import aga.easyit.dto.FlashCardDTO;
import aga.easyit.exception.CardNotFoundException;
import aga.easyit.mapper.FlashCardMapper;
import aga.easyit.model.Command;
import aga.easyit.model.FlashCard;

@Service
public class FlashCardService {
    private final FlashCardRepository flashCardRepository;
    private final CommandService commandService;
    private final FlashCardMapper fMapper;


    
    public FlashCardService(FlashCardRepository flashCardRepository, CommandService commandService, FlashCardMapper flashCardMapper) {
        this.flashCardRepository = flashCardRepository;
        this.commandService = commandService;
        this.fMapper = flashCardMapper;
    }

    public FlashCard createFlashCard(FlashCardDTO flashCardDTO){
        Command command;
        if(flashCardDTO.commandDTO().argumentDTOs()!=null && !flashCardDTO.commandDTO().argumentDTOs().isEmpty()){
            command= commandService.getOrCreateCommandWithArgs(flashCardDTO.commandDTO());
        }
        FlashCard flashCard= fMapper.toEntity(flashCardDTO);
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
