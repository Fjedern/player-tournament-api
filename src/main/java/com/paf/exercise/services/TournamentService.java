package com.paf.exercise.services;

import com.paf.exercise.entities.Player;
import com.paf.exercise.exceptions.TournamentNotFoundException;
import com.paf.exercise.entities.Tournament;
import com.paf.exercise.repos.PlayerRepo;
import com.paf.exercise.repos.TournamentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {
    private final TournamentRepo tournamentRepo;
    private final PlayerRepo playerRepo;

    @Autowired
    public TournamentService(TournamentRepo tournamentRepo, PlayerRepo playerRepo) {
        this.tournamentRepo = tournamentRepo;
        this.playerRepo = playerRepo;
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

    public Tournament findTournamentById(int id) throws TournamentNotFoundException {
        return tournamentRepo.findTournamentById(id).orElseThrow(() -> new TournamentNotFoundException("Tournament by id " + id + " was not found"));
    }

    public void deleteTournament(int id){
        tournamentRepo.deleteTournamentById(id);
    }

    @Transactional
    public Tournament addPlayerToTournament(int tournamentId, int playerId) {
        Optional<Tournament> optionalTournament = tournamentRepo.findById(tournamentId);
        Optional<Player> optionalPlayer = playerRepo.findPlayerById(playerId);

        if(optionalTournament.isPresent() && optionalPlayer.isPresent()){
            Tournament tournament = optionalTournament.get();
            Player player = optionalPlayer.get();

            System.out.println(player);
            tournament.addPlayerToList(player);
            tournamentRepo.save(tournament);
            return tournament;
        }
        return null;
    }
}

//30 min