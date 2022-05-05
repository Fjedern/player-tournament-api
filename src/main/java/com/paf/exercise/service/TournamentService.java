package com.paf.exercise.service;

import com.paf.exercise.exception.TournamentNotFoundException;
import com.paf.exercise.model.Tournament;
import com.paf.exercise.repo.TournamentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

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
}

//30 min