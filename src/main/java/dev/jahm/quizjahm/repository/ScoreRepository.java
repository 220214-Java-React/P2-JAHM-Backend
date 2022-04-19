package dev.jahm.quizjahm.repository;


import dev.jahm.quizjahm.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {

    /**
     * Return a list of Scores Based on the player id
     * @param player_id to search by
     * @return Matching List of Scores
     */
    List<Score> getAllByPlayerId (int player_id);
}
