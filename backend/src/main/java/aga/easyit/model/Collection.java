package aga.easyit.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long collectionId;
    private String title;
    
    @ManyToMany
    @JoinTable(name="deck", joinColumns = @JoinColumn(name="collection_id"), inverseJoinColumns = @JoinColumn(name="flashcard_id"))
    private List<FlashCard> flashcards=new ArrayList<>();
}
