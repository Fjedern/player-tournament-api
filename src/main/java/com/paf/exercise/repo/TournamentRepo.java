package com.paf.exercise.repo;

import com.paf.exercise.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TournamentRepo extends JpaRepository<Tournament, Long> {
    void deleteTournamentById(Long id);

    Optional<Tournament> findTournamentById(Long id); //Might not have a tournament so has to be optional
}
