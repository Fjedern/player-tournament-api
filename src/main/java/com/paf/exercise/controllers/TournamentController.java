package com.paf.exercise.controllers;
import com.paf.exercise.exceptions.TournamentNotFoundException;
import com.paf.exercise.entities.Tournament;
import com.paf.exercise.services.TournamentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {
    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @GetMapping()
    public ResponseEntity<List<Tournament>> getAllTournaments() {
        List<Tournament> tournaments = tournamentService.findAllTournaments();
        return new ResponseEntity<>(tournaments, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable("id") int id) throws TournamentNotFoundException {
        Tournament tournament = tournamentService.findTournamentById(id);
        return new ResponseEntity<>(tournament, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Tournament> addTournament(@RequestBody Tournament tournament) {
        Tournament newTournament = tournamentService.addTournament(tournament);
        return new ResponseEntity<>(newTournament, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Tournament> updateTournament(@RequestBody Tournament tournament) {
        Tournament updateTournament = tournamentService.updateTournament(tournament);
        return new ResponseEntity<>(updateTournament, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTournament(@PathVariable("id") int id) {
        tournamentService.deleteTournament(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/addPlayerToTournament/{tournamentId}/{playerId}")
    public ResponseEntity<?> addPlayerToTournament(@PathVariable int tournamentId, @PathVariable int playerId) {
        Tournament updateTournament = tournamentService.addPlayerToTournament(tournamentId, playerId);
        return new ResponseEntity<>(updateTournament, HttpStatus.OK);
    }
}
