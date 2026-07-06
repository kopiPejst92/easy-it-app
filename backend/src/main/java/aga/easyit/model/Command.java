package aga.easyit.model;

import java.io.Serializable;
import java.util.List;
import aga.easyit.dictionary.CommandCategory;
import jakarta.persistence.*;

@Entity
public class Command implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false, unique = false)
    private String base;
    @Column(nullable = true, unique = false)
    private String shortVer;
    private CommandCategory category;
    @Column(nullable=false, unique=false)
    private String description;
    @ManyToOne
    @JoinColumn(name="library_id")
    private Library library;
    @OneToMany(mappedBy = "command", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FlashCard> flashcards;
    @OneToMany(mappedBy = "command", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Argument> argumentsList;
    @ManyToOne
    @JoinColumn(name="runMode_id")
    private RunMode runMode;
    @Column(nullable=true, unique=false)
    private String documentationUrl;
    @Column(nullable=true, unique=false)
    private String keyShrt;

    public Command(String base, String description) {
        this.base = base;
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

        public String getBase() {
        return base;
    }

    public void setBase(String name) {
        this.base = name;
    }

       public String getShortVer() {
        return shortVer;
    }

    public void setShortVer(String shortName) {
        this.shortVer = shortName;
    }

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

    public RunMode getRunMode() {
        return runMode;
    }

    public void setRunMode(RunMode runMode) {
        this.runMode = runMode;
    }
}
