package dev.jahm.quizjahm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Scores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Score {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scoreID;

    private int points;
    private String quizMode;
    private String quizDifficulty;

    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private User player;



}
