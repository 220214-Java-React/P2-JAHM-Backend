package dev.jahm.quizjahm.controller;


import dev.jahm.quizjahm.model.Score;
import dev.jahm.quizjahm.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scores")
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @PostMapping
    public void createNewScore (@RequestBody Score score){scoreService.createNewScore(score);}

    @GetMapping("/{playerId}")
    public List<Score> getAllByPlayerId(@PathVariable int playerId){return scoreService.getAllByPlayerId(playerId);}

}
