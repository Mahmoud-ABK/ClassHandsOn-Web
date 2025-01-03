package org.tpwebavancee.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;

@Entity
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTeam;

    @Column(length = 100)
    private String name;
    @OneToMany(mappedBy = "myteam") // Defines a one-to-many relationship with the Player entity
    private Collection<Player> players; // Collection of players in the team

    public Collection<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Collection<Player> players) {
        this.players = players;
    }

    // Constructors
    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    // Getters and Setters
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

    // Optionally, Override toString(), equals(), and hashCode() as needed
}
