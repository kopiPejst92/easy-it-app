package aga.easyit.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import aga.easyit.model.FlashCard;

public interface FlashCardRepository extends JpaRepository<FlashCard, Long>{

    void deleteFlashCardById(Long id);

    Optional<FlashCard> findFlashCardById(Long id);
    
}
