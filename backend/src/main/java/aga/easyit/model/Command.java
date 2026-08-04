package aga.easyit.model;

import java.io.Serializable;
import java.util.List;
// import aga.easyit.dictionary.CommandCategory;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="commands")
public class Command implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false, unique = false)
    private String syntax;
    // @Column(nullable = true, unique = false)
    // private String shortVer;
    // private CommandCategory category;
    @Column(nullable=false, unique=false)
    private String description;
    @Column(nullable=false, unique = true)
    private String tool;
    // @ManyToOne
    // @JoinColumn(name="library_id")
    // private Library library;
    @OneToMany(mappedBy = "command", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FlashCard> flashcards;
    @OneToMany(mappedBy = "command", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Argument> arguments;
    // @ManyToOne
    // @JoinColumn(name="runMode_id")
    // private RunMode runMode;
    // @Column(nullable=true, unique=false)
    // private String documentationUrl;
    // @Column(nullable=true, unique=false)
    // private String keyShrt;

    public Command(String base, String description) {
        this.syntax = base;
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

        public String getSyntax() {
        return syntax;
    }

    public void setSyntax(String name) {
        this.syntax = name;
    }

    //    public String getShortVer() {
    //     return shortVer;
    // }

    // public void setShortVer(String shortName) {
    //     this.shortVer = shortName;
    // }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    // public Library getLibrary() {
    //     return library;
    // }
    // public void setLibrary(String lName) {
    //     this.library = new Library(lName);
    // }

       
    // public CommandCategory getCategory() {
    //     return category;
    // }

    // public void setCategory(CommandCategory category) {
    //     this.category = category;
    // }

    // public RunMode getRunMode() {
    //     return runMode;
    // }

    // public void setRunMode(RunMode runMode) {
    //     this.runMode = runMode;
    // }

    public List<Argument> getArguments() {
        return arguments;
    }

    public void setArguments(List<Argument> argumentsList) {
        this.arguments = argumentsList;
    }

       public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }
}
