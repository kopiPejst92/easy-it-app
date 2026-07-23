package aga.easyit.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aga.easyit.dto.FlashCardDTO;
import aga.easyit.model.FlashCard;
import aga.easyit.service.FlashCardService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/flashcard")
public class FlashCardController {
    private final FlashCardService flashCardService;

    public FlashCardController(FlashCardService flashCardService) {
        this.flashCardService = flashCardService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<FlashCard>> getAllFlashCards(){
        List<FlashCard> flashCards= flashCardService.findAllFlashCards();
        return new ResponseEntity<>(flashCards, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<List<FlashCard>> getFlashCardById(@PathVariable("id") Long id){
        List<FlashCard> flashCards= flashCardService.findAllFlashCards();
        return new ResponseEntity<>(flashCards, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<FlashCardDTO> addFlashCard(@Valid @RequestBody FlashCardDTO flashCardDTO){
        FlashCardDTO savedFlashCard = flashCardService.createFlashCard(flashCardDTO);
        return new ResponseEntity(savedFlashCard, HttpStatus.CREATED);

    }
}
