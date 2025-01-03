package org.tpwebavancee.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

@Entity  // Marks this class as an entity, meaning it will be mapped to a database table
public class Player implements Serializable {

    @Id  // Specifies that this field is the primary key of the entity
    @GeneratedValue  // Indicates that the value of the idPlayer will be automatically generated (usually by the database)
    private Long idPlayer;  // The primary key field for the Player entity

    @Column(length = 100)  // Specifies a column in the database with a maximum length of 100 characters
    private String name;  // The name of the player

    @ManyToOne  // Indicates a many-to-one relationship between Player and Team, meaning each player belongs to one team
    @JoinColumn(name = "idTeam")  // Specifies the foreign key column in the Player table that refers to the Team table
    private Team myteam;  // The team to which the player belongs

    public Player(String name, Long idPlayer) {
        this.name = name;
        this.idPlayer = idPlayer;
    }

    public Player(Long idPlayer) {
        this.idPlayer = idPlayer;
    }

    public Player(Team myteam, String name, Long idPlayer) {
        this.myteam = myteam;
        this.name = name;
        this.idPlayer = idPlayer;
    }

    public Player() {

    }

    public Player(String name, Team myteam) {
        this.name = name;
        this.myteam = myteam;
    }

    public Long getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(Long idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getMyteam() {
        return myteam;
    }

    public void setMyteam(Team myteam) {
        this.myteam = myteam;
    }
}

