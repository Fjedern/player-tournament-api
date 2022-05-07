package com.paf.exercise.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tournaments")
public class Tournament implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(name = "name")
    private String tournament_name;
    @Column(name = "prize")
    private int prize;


    @ManyToMany
    @JoinTable(
            name = "player_tournament",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    private Set<Player> players;

    public Tournament(){}

    public Tournament(String tournament_name, int prize) {
        this.tournament_name = tournament_name;
        this.prize = prize;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTournament_name() {
        return tournament_name;
    }

    public void setTournament_name(String tournament_name) {
        this.tournament_name = tournament_name;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "tournament_id=" + id +
                ", tournament_name='" + tournament_name + '\'' +
                ", tournament_prize=" + prize +
                '}';
    }
}





