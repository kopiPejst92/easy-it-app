package aga.easyit.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aga.easyit.dto.FlashCardDTO;
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
    public ResponseEntity<List<FlashCardDTO>> getAllFlashCards(){
        List<FlashCardDTO> found = flashCardService.findAllFlashCards();
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<FlashCardDTO> getFlashCardById(@PathVariable("id") Long id){
        FlashCardDTO flashCard= flashCardService.findFlashCardById(id);
        return new ResponseEntity<>(flashCard, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<FlashCardDTO> addFlashCard(@Valid @RequestBody FlashCardDTO flashCardDTO){
        FlashCardDTO newFlashCard = flashCardService.createFlashCard(flashCardDTO);
        return new ResponseEntity<>(newFlashCard, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<FlashCardDTO> updateFlashCard(@Valid @RequestBody FlashCardDTO flashCardDTO){
        FlashCardDTO updatedFlashCard = flashCardService.updateFlashCard(flashCardDTO);
        return new ResponseEntity<>(updatedFlashCard, HttpStatus.OK);
    }
}
