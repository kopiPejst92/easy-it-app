package com.aga.flashcommand.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aga.flashcommand.model.FlashCard;

public interface FlashCardRepository extends JpaRepository<FlashCard, Long>{

    void deleteFlashCardById(Long id);

    Optional<FlashCard> findFlashCardById(Long id);
    
}
