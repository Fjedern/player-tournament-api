package com.paf.exercise.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paf.exercise.entities.Tournament;
import com.paf.exercise.exception.PlayerNotFoundException;
import com.paf.exercise.exception.TournamentNotFoundException;
import com.paf.exercise.entities.Player;
import com.paf.exercise.service.PlayerService;
import org.h2.util.json.JSONObject;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

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
    public ResponseEntity<Player> addTournament(@RequestBody Player player) throws JsonProcessingException {
        Player newPlayer = playerService.addPlayer(player);
        System.out.println(newPlayer);
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = mapper.writeValueAsString(player);
        System.out.println(jsonString);
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

    /*@Transactional
    @Modifying
    @PostMapping("/addPlayerToTournament")
    public ResponseEntity<?> addPlayerToTournament(@RequestBody Long player_id, Long tournament_id) throws PlayerNotFoundException {
        Player tmpPlayer = playerService.findPlayerById(player_id);
        Tournament tmpTournament = playerService.fin
        tmpPlayer.setTournaments((Set<Tournament>) tournament_id);

        return new ResponseEntity<>(HttpStatus.OK);
    }*/

    @GetMapping("/viewTournaments/{id}")
    public Set<Tournament> getTournaments(@PathVariable("id") Long id) throws PlayerNotFoundException {
        Player player = playerService.findPlayerById(id);
        return player.getTournaments();
    }
}
