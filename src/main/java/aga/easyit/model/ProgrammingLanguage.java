package aga.easyit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ProgrammingLanguage {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String developer; 
    //todo change to enum
    String abstractLevel;
    
}
