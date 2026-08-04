package aga.easyit.service;

import aga.easyit.repo.FlashCardRepository;
import aga.easyit.service.parser.MasterCommandParser;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

import aga.easyit.dto.CommandDTO;
import aga.easyit.dto.FlashCardDTO;
import aga.easyit.exception.CardNotFoundException;
import aga.easyit.mapper.ArgumentMapper;
import aga.easyit.mapper.FlashCardMapper;
import aga.easyit.model.Command;
import aga.easyit.model.FlashCard;

@Service
public class FlashCardService {
    private final FlashCardRepository flashCardRepository;
    private final FlashCardMapper flashCardMapper;
    private final ArgumentMapper argumentMapper;
    private final MasterCommandParser parser;
    private final CommandService commandService;
    
    public FlashCardService(FlashCardRepository flashCardRepository, FlashCardMapper flashCardMapper, ArgumentMapper argumentMapper, MasterCommandParser parser, CommandService commandService) {
        this.flashCardRepository = flashCardRepository;
        this.flashCardMapper=flashCardMapper;
        this.argumentMapper = argumentMapper;
        this.parser=parser;
        this.commandService = commandService;
    }

    @Transactional
    public FlashCardDTO createFlashCard(FlashCardDTO fcDTO) {
        CommandDTO commandDTO;
        FlashCard flashCard;
        flashCard = flashCardMapper.toEntity(fcDTO);
        if(fcDTO.rawCommandString() != null && !fcDTO.rawCommandString().isBlank()){
            commandDTO = parser.parse(fcDTO.rawCommandString());
            Command command = commandService.getOrCreateCommand(commandDTO);
            command.setArguments(argumentMapper.toEntityList(commandDTO.arguments()));
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
