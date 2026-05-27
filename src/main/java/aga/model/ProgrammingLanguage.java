package aga.model;

import jakarta.persistence.Entity;

@Entity
public class ProgrammingLanguage {
    Long id;
    String developer; 
    //todo change to enum
    String abstractLevel;
    
}
