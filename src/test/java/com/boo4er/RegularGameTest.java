package com.boo4er;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class RegularGameTest {
    @Test
    void gameIsNotFinishedWhenFirstPlayerScoredThreePoints() {
        RegularGame regularGame = new RegularGame();
        regularGame.scorePoint(GamePlayer.FIRST);
        regularGame.scorePoint(GamePlayer.FIRST);
        regularGame.scorePoint(GamePlayer.FIRST);
        assertFalse(regularGame.isFinished());
    }
}
