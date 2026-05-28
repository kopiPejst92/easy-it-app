package aga.easyit.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Framework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String fType;
    @OneToMany(mappedBy = "framework", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Library> libraryList;
    @OneToMany(mappedBy = "framework", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Command> commandsList;
    
    public Framework(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getfType() {
        return fType;
    }
    public void setfType(String fType) {
        this.fType = fType;
    }

    
}
