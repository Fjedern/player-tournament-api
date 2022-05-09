package com.paf.exercise.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "tournaments")
public class Tournament implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int id;
    @Column(name = "name")
    private String tournament_name;
    @Column(name = "prize")
    private int tournament_prize;


    @ManyToMany
    @JoinTable(
            name = "player_tournament",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    private Set<Player> players;

    public Tournament() {
    }

    public Tournament(String tournament_name, int prize) {
        this.tournament_name = tournament_name;
        this.tournament_prize = prize;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public void addPlayerToList(Player player) {
        players.add(player);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTournament_name() {
        return tournament_name;
    }

    public void setTournament_name(String tournament_name) {
        this.tournament_name = tournament_name;
    }

    public int getTournament_prize() {
        return tournament_prize;
    }

    public void setTournament_prize(int tournament_prize) {
        this.tournament_prize = tournament_prize;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "tournament_id=" + id +
                ", tournament_name='" + tournament_name + '\'' +
                ", tournament_prize=" + tournament_prize +
                '}';
    }
}





