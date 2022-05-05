package com.paf.exercise.repo;
import com.paf.exercise.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Long> {
    void deletePlayerById(Long id);

    Optional<Player> findPlayerById(Long id);
}
