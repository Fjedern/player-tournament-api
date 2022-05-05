package com.paf.exercise.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Tournament implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    public Long id;
    public String tournament_name;
    public int tournament_prize;

    public Tournament(){}

    public Tournament(String tournament_name, int tournament_prize) {
        this.tournament_name = tournament_name;
        this.tournament_prize = tournament_prize;
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





