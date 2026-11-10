package com.boo4er;

import org.junit.jupiter.api.Test;

import static com.boo4er.GameTestHelper.scorePoints;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TieBreakGameTest {

    @Test
    void tieGameIsFinishedWhenFirstPlayerScoredSevenPoints() {
        TieBreakGame tieBreakGame = new TieBreakGame();
        scorePoints(tieBreakGame, GamePlayer.FIRST, 7);
        assertTrue(tieBreakGame.isFinished());
        assertEquals(GamePlayer.FIRST, tieBreakGame.findWinner());
    }

    @Test
    void tieGameIsNotFinishedWhenFirstPlayerScoredSixPointsAndSecondPlayerScoredFourPoints() {
        TieBreakGame tieBreakGame = new TieBreakGame();
        scorePoints(tieBreakGame, GamePlayer.FIRST, 3);
        scorePoints(tieBreakGame, GamePlayer.SECOND, 4);
        scorePoints(tieBreakGame, GamePlayer.FIRST, 3);
        assertFalse(tieBreakGame.isFinished());
    }

    @Test
    void tieGameIsNotFinishedWhenFirstPlayerScoredSevenPointsAndSecondPlayerScoredSixPoints() {
        TieBreakGame tieBreakGame = new TieBreakGame();
        scorePoints(tieBreakGame, GamePlayer.FIRST, 3);
        scorePoints(tieBreakGame, GamePlayer.SECOND, 6);
        scorePoints(tieBreakGame, GamePlayer.FIRST, 4);
        assertFalse(tieBreakGame.isFinished());
    }

    @Test
    void tieGameIsNotFinishedWhenFirstPlayerScoredSixPointsAndSecondPlayerScoredSixPoints() {
        TieBreakGame tieBreakGame = new TieBreakGame();
        scorePoints(tieBreakGame, GamePlayer.FIRST, 3);
        scorePoints(tieBreakGame, GamePlayer.SECOND, 6);
        scorePoints(tieBreakGame, GamePlayer.FIRST, 3);
        assertFalse(tieBreakGame.isFinished());
    }

    @Test
    void tieGameIsFinishedWhenSecondPlayerScoredSevenPoints() {
        TieBreakGame tieBreakGame = new TieBreakGame();
        scorePoints(tieBreakGame, GamePlayer.SECOND, 7);
        assertTrue(tieBreakGame.isFinished());
        assertEquals(GamePlayer.SECOND, tieBreakGame.findWinner());
    }

    @Test
    void tieGameIsFinishedWhenFirstPlayerScoredNinePointsAndSecondPlayerScoredSevenPoints() {
        TieBreakGame tieBreakGame = new TieBreakGame();
        scorePoints(tieBreakGame, GamePlayer.FIRST, 6);
        scorePoints(tieBreakGame, GamePlayer.SECOND, 7);
        scorePoints(tieBreakGame, GamePlayer.FIRST, 3);
        assertTrue(tieBreakGame.isFinished());
        assertEquals(GamePlayer.FIRST, tieBreakGame.findWinner());
    }

    @Test
    void tieGameThrowsExceptionWhenFirstPlayerScoredTwoPointsAndSecondPlayerScoredOnePoint() {
        TieBreakGame tieBreakGame = new TieBreakGame();
        scorePoints(tieBreakGame, GamePlayer.FIRST, 2);
        scorePoints(tieBreakGame, GamePlayer.SECOND, 1);
        assertThrows(IllegalStateException.class, () -> tieBreakGame.findWinner());
    }

    @Test
    void scorePointThrowsExceptionWhenGameIsFinished() {
        TieBreakGame tieBreakGame = new TieBreakGame();
        scorePoints(tieBreakGame, GamePlayer.FIRST, 7);
        assertThrows(IllegalStateException.class, () -> tieBreakGame.scorePoint(GamePlayer.SECOND));
    }

}
