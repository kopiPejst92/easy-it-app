package aga.easyit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import aga.easyit.model.FlashCard;

public interface FlashCardRepository extends JpaRepository<FlashCard, Long>{
    
    
}
