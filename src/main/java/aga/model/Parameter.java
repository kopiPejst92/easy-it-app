package aga.model;

import jakarta.persistence.Entity;

@Entity
public abstract class Parameter {
    private Long id;
    private String name;
    private String description;
    
}
