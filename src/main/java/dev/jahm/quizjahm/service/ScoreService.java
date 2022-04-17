package dev.jahm.quizjahm.service;

import dev.jahm.quizjahm.model.Score;
import dev.jahm.quizjahm.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    @Autowired
    ScoreRepository scoreRepository;

    public List<Score> getAllByPlayerId (int playerId){

        return scoreRepository.getAllByPlayerId(playerId);
    }

    public void createNewScore(Score score) {
        scoreRepository.save(score);
    }
}
