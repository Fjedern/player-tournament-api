package com.paf.exercise.service;

import com.paf.exercise.entities.Player;
import com.paf.exercise.exception.TournamentNotFoundException;
import com.paf.exercise.entities.Tournament;
import com.paf.exercise.repo.TournamentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TournamentService {
    private final TournamentRepo tournamentRepo;

    @Autowired
    public TournamentService(TournamentRepo tournamentRepo) {
        this.tournamentRepo = tournamentRepo;
    }

    public Tournament addTournament(Tournament tournament){
        return tournamentRepo.save(tournament);
    }

    public List<Tournament> findAllTournaments(){
        return tournamentRepo.findAll();
    }

    public Tournament updateTournament(Tournament tournament){
        return tournamentRepo.save(tournament);
    }

    public Tournament findTournamentById(Long id) throws TournamentNotFoundException {
        return tournamentRepo.findTournamentById(id).orElseThrow(() -> new TournamentNotFoundException("Tournament by id " + id + " was not found"));
    }

    public void deleteTournament(Long id){
        tournamentRepo.deleteTournamentById(id);
    }

    public void addPlayerToTournament(Long tournamentId, Set<Player> players) {
        Optional<Tournament> tournamentOptional = tournamentRepo.findById(tournamentId);
        Tournament tournament = tournamentOptional.get();
        players.addAll(tournament.getPlayers());
        tournament.setPlayers(players);
        tournamentRepo.save(tournament);
    }
}

//30 min