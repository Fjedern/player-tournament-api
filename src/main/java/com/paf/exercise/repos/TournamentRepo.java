package com.paf.exercise.repos;

import com.paf.exercise.entities.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TournamentRepo extends JpaRepository<Tournament, Integer> {
    void deleteTournamentById(int id);

    Optional<Tournament> findTournamentById(int id); //Might not have a tournament so has to be optional
}
