package dev.jahm.quizjahm;

import dev.jahm.quizjahm.model.Score;
import dev.jahm.quizjahm.model.User;
import dev.jahm.quizjahm.repository.ScoreRepository;
import dev.jahm.quizjahm.service.ScoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ScoreServiceTest {
    @Autowired
    ScoreService scoreService;

    @MockBean
    ScoreRepository scoreRepository;

    User user1 = new User(2, "Test1", "test");
    Score score1 = new Score(1, 100,"Timed","Easy", user1);
    User user2 = new User(1, "Test2", "test");
    Score score2 = new Score(2, 100,"Timed","Easy", user2);
    int playerId = 1;
    List<Score> scores = new ArrayList<>();



    @Test
    public void givenPlayerIdReturnsScoreList( ){

        scores.add(score1);
        scores.add(score2);

        Mockito.when(scoreRepository.getAllByPlayerId(playerId)).thenReturn(scores);

        List<Score> results= scoreService.getAllByPlayerId(playerId);

        Assertions.assertEquals(scores.get(0),results.get(0) );

    }

    @Test
    public void givenScoreDataCreateDoesNotThrowException(){

        Assertions.assertDoesNotThrow( () -> scoreService.createNewScore(score1) );

   }

}
