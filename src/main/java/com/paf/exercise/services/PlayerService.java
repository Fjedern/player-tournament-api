package com.paf.exercise.services;
import com.paf.exercise.exceptions.PlayerNotFoundException;
import com.paf.exercise.entities.Player;
import com.paf.exercise.repos.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepo playerRepo;

    @Autowired
    public PlayerService(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    public Player addPlayer(Player player){
        return playerRepo.save(player);
    }

    public List<Player> findAllPlayers(){
        return playerRepo.findAll();
    }

    public Player updatePlayer(Player player){
        return playerRepo.save(player);
    }

    public Player findPlayerById(int id) throws PlayerNotFoundException {
        return playerRepo.findPlayerById(id).orElseThrow(() -> new PlayerNotFoundException("Player by id " + id + " was not found"));
    }

    public void deletePlayer(int id){
        playerRepo.deletePlayerById(id);
    }
}
