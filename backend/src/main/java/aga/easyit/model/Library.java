package aga.easyit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    // @OneToMany(mappedBy = "library", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // private List<Command> commandList;
    // @ManyToOne
    // @JoinColumn(name="framework_id")
    // private Framework framework;
    
    public Library(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // public Framework getFramework() {
    //     return framework;
    // }
    // public void setFramework(Framework framework) {
    //     this.framework = framework;
    // }
}

