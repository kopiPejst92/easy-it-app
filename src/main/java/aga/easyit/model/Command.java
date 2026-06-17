package aga.easyit.model;

import java.io.Serializable;
import java.util.List;

import aga.easyit.dictionary.CommandCategory;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Command implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false, unique = false)
    private String name;
    @Column(nullable = true, unique = false)
    private String shortName;
    // private String level;
    private CommandCategory category;
    @Column(nullable=false, unique=false)
    private String description;
    //private String details;
    @ManyToOne
    @JoinColumn(name="library_id")
    private Library library;
    @OneToMany(mappedBy = "command", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FlashCard> flashcards;
    // private RunMode runMode;
    // private String documentationUrl;
    // private String keyShrt;
    
    

    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

       public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    //public String getLevel() {
    //     return level;
    // }

    //public void setLevel(String level) {
    //     this.level = level;
    // }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Library getLibrary() {
        return library;
    }
    public void setLibrary(String lName) {
        this.library = new Library(lName);
    }

       
    public CommandCategory getCategory() {
        return category;
    }

    public void setCategory(CommandCategory category) {
        this.category = category;
    }

    // public List<Parameter> getParametersList() {
    //     return parametersList;
    // }

    // public void setParametersList(List<Parameter> parametersList) {
    //     this.parametersList = parametersList;
    // }
}
