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
    private int id;
    @Column(name = "name")
    private String player_name;

    public Player() {
    }

    public Player(String player_name) {
        this.player_name = player_name;
    }

    public int getPlayer_id() {
        return id;
    }

    public void setPlayer_id(int player_id) {
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
