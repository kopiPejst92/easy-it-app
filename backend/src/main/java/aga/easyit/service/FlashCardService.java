package aga.easyit.service;

import aga.easyit.repo.FlashCardRepository;
import jakarta.transaction.Transactional;
import java.util.List;

import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import org.springframework.stereotype.Service;
import aga.easyit.dto.FlashCardDTO;
import aga.easyit.exception.CardNotFoundException;
import aga.easyit.exception.CommandNotFoundException;
import aga.easyit.mapper.ArgumentMapper;
import aga.easyit.mapper.FlashCardMapper;
import aga.easyit.model.Argument;
import aga.easyit.model.Command;
import aga.easyit.model.FlashCard;

@Service
public class FlashCardService {
    private final FlashCardRepository flashCardRepository;
    private final CommandService commandService;
    private final FlashCardMapper flashCardMapper;
    private final ArgumentMapper argumentMapper;
    
    public FlashCardService(FlashCardRepository flashCardRepository, CommandService commandService, FlashCardMapper flashCardMapper, ArgumentMapper argumentMapper) {
        this.flashCardRepository = flashCardRepository;
        this.commandService = commandService;
        this.flashCardMapper=flashCardMapper;
        this.argumentMapper = argumentMapper;
    }

    @Transactional
    public FlashCardDTO createFlashCard(FlashCardDTO fcDTO) {
        Command command;
        List<Argument> arguments;
        if(fcDTO.rawCommandString()!= null && !fcDTO.rawCommandString().isBlank()){
            //parsowanie
        }
        else{
            if(fcDTO.commandDTO()==null){
                throw new CommandNotFoundException(null);
            }
            command=commandService.getOrCreateCommand(fcDTO.commandDTO());
            arguments=argumentMapper.toEntityList(fcDTO.argumentDTOs());
        }
        FlashCard flashCard = flashCardMapper.toEntity(fcDTO);
        // flashCard.setCommand(command);
        FlashCard savedFlashCard = flashCardRepository.save(null);
        return flashCardMapper.toDto(savedFlashCard);  
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