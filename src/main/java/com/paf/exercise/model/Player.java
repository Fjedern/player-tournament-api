package com.paf.exercise.model;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Id;


@Entity
public class Player implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    public Long player_id;
    public String player_name;

    public Player(){}

    public Long getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(Long player_id) {
        this.player_id = player_id;
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
                "player_id=" + player_id +
                ", player_name='" + player_name + '\'' +
                '}';
    }
}
