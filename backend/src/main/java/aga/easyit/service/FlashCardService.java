package aga.easyit.service;

import aga.easyit.repo.FlashCardRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;
import aga.easyit.dto.FlashCardDTO;
import aga.easyit.exception.CardNotFoundException;
import aga.easyit.mapper.FlashCardMapper;
import aga.easyit.model.Command;
import aga.easyit.model.FlashCard;

@Service
public class FlashCardService {
    private final FlashCardRepository flashCardRepository;
    private final FlashCardMapper flashCardMapper;
    private final CommandService commandService;
    
    public FlashCardService(FlashCardRepository flashCardRepository, FlashCardMapper flashCardMapper, CommandService commandService) {
        this.flashCardRepository = flashCardRepository;
        this.flashCardMapper=flashCardMapper;
        this.commandService = commandService;
    }

    @Transactional
    public FlashCardDTO createFlashCard(FlashCardDTO fcDTO) {
        Command command = commandService.getOrCreateCommand(fcDTO.rawCommandString(), fcDTO.command());
        FlashCard flashCard = flashCardMapper.toEntity(fcDTO);
        if(flashCard.getCommand()==null){
            flashCard.setCommand(command);
        }
        FlashCard saved = flashCardRepository.save(flashCard);
        return flashCardMapper.toDto(saved);  
    }

    public FlashCard updateFlashCard(FlashCard flashCard){
        return flashCardRepository.save(flashCard);
    }

    public List<FlashCard> findAllFlashCards(){
        return flashCardRepository.findAll();
    }

    public FlashCard findFlashCardById(Long id){
        return flashCardRepository.findFlashCardById(id).orElseThrow(() -> new CardNotFoundException("Flash card"+id+" is not found"));
    }

    public void deleteFlashCard(Long id){
        flashCardRepository.deleteFlashCardById(id);
    }
}
