package aga.easyit.service;

import aga.easyit.repo.FlashCardRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aga.easyit.exception.CardNotFoundException;
import aga.easyit.model.FlashCard;

@Service
public class FlashCardService {
    private final FlashCardRepository flashCardRepository;

    @Autowired
    public FlashCardService(FlashCardRepository flashCardRepository){
        this.flashCardRepository = flashCardRepository;
    }

    public FlashCard addFlashCard(FlashCard flashCard){
        flashCard.setName("b");
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
