package org.tpwebavancee.spring_mvc.entities;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTeam ;// Primary key with auto-increment behavior

    @Column(length = 100)
    private String name;

    private Float budget;

    // Constructors
    public Team() {
    }

    public Team(String name, Float budget) {
        this.name = name;
        this.budget = budget;
    }

    // Getters and setters
    public Long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Long idTeam) {
        this.idTeam = idTeam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getBudget() {
        return budget;
    }

    public void setBudget(Float budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Team{" +
                "idTeam=" + idTeam +
                ", name='" + name + '\'' +
                ", budget=" + budget +
                '}';
    }
}

