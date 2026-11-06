package com.boo4er;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RegularGameTest {

    private void scorePoints(RegularGame game, GamePlayer player, int count) {
        for (int i = 0; i < count; i++) {
            game.scorePoint(player);
        }
    }

    @Test
    void gameIsNotFinishedWhenFirstPlayerScoredThreePoints() {
        RegularGame regularGame = new RegularGame();
        scorePoints(regularGame, GamePlayer.FIRST, 3);
        assertFalse(regularGame.isFinished());
    }

    @Test
    void gameIsFinishedWhenFirstPlayerScoredFourPoints() {
        RegularGame regularGame = new RegularGame();
        scorePoints(regularGame, GamePlayer.FIRST, 4);
        assertTrue(regularGame.isFinished());
        assertEquals(GamePlayer.FIRST, regularGame.findWinner());
    }

    @Test
    void gameIsNotFinishedWhenFirstPlayerScoredFourPointsAndSecondPlayerScoredThreePoints() {
        RegularGame regularGame = new RegularGame();
        scorePoints(regularGame, GamePlayer.FIRST, 3);
        scorePoints(regularGame, GamePlayer.SECOND, 3);
        scorePoints(regularGame, GamePlayer.FIRST, 1);
        assertFalse(regularGame.isFinished());
    }

    @Test
    void gameIsNotFinishedWhenFirstPlayerScoredFivePointsAndSecondPlayerScoredFourPoints() {
        RegularGame regularGame = new RegularGame();
        scorePoints(regularGame, GamePlayer.FIRST, 3);
        scorePoints(regularGame, GamePlayer.SECOND, 4);
        scorePoints(regularGame, GamePlayer.FIRST, 2);
        assertFalse(regularGame.isFinished());
    }

}
