package com.paf.exercise.repos;
import com.paf.exercise.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Integer> {
    void deletePlayerById(int id);

    Optional<Player> findPlayerById(int id);
}
