package com.paf.exercise.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Id;

@Entity
@Table(name = "players")
public class Player implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(name = "name")
    private String player_name;

    @ManyToMany(mappedBy = "players", fetch = FetchType.LAZY)
    private Set<Tournament> tournaments;

    public Player() {
    }

    public Set<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(Set<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    public Player(String player_name) {
        this.player_name = player_name;
    }

    public Long getPlayer_id() {
        return id;
    }

    public void setPlayer_id(Long player_id) {
        this.id = player_id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "player_id=" + id +
                ", player_name='" + player_name + '\'' +
                '}';
    }
}
