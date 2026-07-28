package aga.easyit.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "flashcards")
public class FlashCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false, updatable = true)
    private String title;
    @ManyToOne
    @JoinColumn(name = "command_id") // Maps the foreign key column in the DB
    private Command command;
    List<String> problemTags;

    public FlashCard(String title, Command command){
        this.title=title;
        this.command=command;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String name) {
        this.title = name;
    }

    public void setCommand(Command command) {
        this.command=command;
    }  

    public Command getCommand() {
        return this.command;
    }  

    public List<String> getProblemTags() {
        return problemTags;
    }

    public void setProblemTags(List<String> problemTags) {
        this.problemTags = problemTags;
    }
}
