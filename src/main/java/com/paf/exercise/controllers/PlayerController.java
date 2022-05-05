package com.paf.exercise.controllers;

import com.paf.exercise.exception.PlayerNotFoundException;
import com.paf.exercise.exception.TournamentNotFoundException;
import com.paf.exercise.model.Player;
import com.paf.exercise.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping()
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.findAllPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable("id") Long id) throws TournamentNotFoundException, PlayerNotFoundException {
        Player player = playerService.findPlayerById(id);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Player> addTournament(@RequestBody Player player) {
        Player newPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
        Player updatePlayer = playerService.updatePlayer(player);
        return new ResponseEntity<>(updatePlayer, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable("id") Long id) {
        playerService.deletePlayer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
