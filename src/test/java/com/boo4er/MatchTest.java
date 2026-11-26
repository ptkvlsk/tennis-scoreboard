package com.boo4er;

import org.junit.jupiter.api.Test;

import static com.boo4er.TestHelper.scoreFreshSet;
import static org.junit.jupiter.api.Assertions.*;

public class MatchTest {

    @Test
    void matchIsNotFinishedWhenFirstPlayerWinOneSet() {
        Match match = new Match();
        scoreFreshSet(match, GamePlayer.FIRST);
        assertFalse(match.isFinished());
    }

    @Test
    void matchIsFinishedWhenFirstPlayerWinTwoSets() {
        Match match = new Match();
        scoreFreshSet(match, GamePlayer.FIRST);
        scoreFreshSet(match, GamePlayer.FIRST);
        assertTrue(match.isFinished());
    }

    @Test
    void matchIsFinishedWhenFirstPlayerWinTwoSetsAndSecondPlayerWinOneSet() {
        Match match = new Match();
        scoreFreshSet(match, GamePlayer.FIRST);
        scoreFreshSet(match, GamePlayer.SECOND);
        scoreFreshSet(match, GamePlayer.FIRST);
        assertTrue(match.isFinished());
    }

    @Test
    void matchIsNotFinishedWhenFirstPlayerWinOneSetAndSecondPlayerWinOneSet() {
        Match match = new Match();
        scoreFreshSet(match, GamePlayer.FIRST);
        scoreFreshSet(match, GamePlayer.SECOND);
        assertFalse(match.isFinished());
    }

    @Test
    void matchIsFinishedWhenSecondPlayerWinTwoSets() {
        Match match = new Match();
        scoreFreshSet(match, GamePlayer.SECOND);
        scoreFreshSet(match, GamePlayer.SECOND);
        assertTrue(match.isFinished());
    }

    @Test
    void scorePointsThrowsExceptionWhenMatchIsFinished() {
        Match match = new Match();
        scoreFreshSet(match, GamePlayer.FIRST);
        scoreFreshSet(match, GamePlayer.FIRST);
        assertThrows(IllegalStateException.class, () -> match.scorePoint(GamePlayer.FIRST));
    }

    @Test
    void firstPlayerWinMatchWhenFirstPlayerWinTwoSets() {
        Match match = new Match();
        scoreFreshSet(match, GamePlayer.FIRST);
        scoreFreshSet(match, GamePlayer.FIRST);
        assertEquals(GamePlayer.FIRST, match.findWinner());
    }

    @Test
    void secondPlayerWinMatchWhenSecondPlayerWinTwoSets() {
        Match match = new Match();
        scoreFreshSet(match, GamePlayer.SECOND);
        scoreFreshSet(match, GamePlayer.SECOND);
        assertEquals(GamePlayer.SECOND, match.findWinner());
    }

    @Test
    void firstPlayerWinMatchWhenFirstPlayerWinTwoSetsAndSecondPlayerWinOneSet() {
        Match match = new Match();
        scoreFreshSet(match, GamePlayer.FIRST);
        scoreFreshSet(match, GamePlayer.SECOND);
        scoreFreshSet(match, GamePlayer.FIRST);
        assertEquals(GamePlayer.FIRST, match.findWinner());
    }

    @Test
    void matchThrowsExceptionWhenFirstPlayerWinOneSet() {
        Match match = new Match();
        scoreFreshSet(match, GamePlayer.FIRST);
        assertThrows(IllegalStateException.class, () -> match.findWinner());
    }

    @Test
    void matchScoreIsZeroToZeroWhenMatchStarts() {
        Match match = new Match();
        assertEquals(new MatchScore(0, 0), match.getMatchScore());
    }

    @Test
    void matchScoreIsOneToZeroWhenFirstPlayerWinOneSet() {
        Match match = new Match();
        scoreFreshSet(match, GamePlayer.FIRST);
        assertEquals(new MatchScore(1, 0), match.getMatchScore());
    }

    @Test
    void gameScoreIsZeroToZeroWhenGameStarts() {
        Match match = new Match();
        assertEquals(new GameScore(0, 0), match.getCurrentMatchScore());
    }

    @Test
    void gameScoreIsZeroToZeroWhenFirstPlayerWinGame() {
        Match match = new Match();
        scoreFreshSet(match, GamePlayer.FIRST);
        assertEquals(new GameScore(0, 0), match.getCurrentMatchScore());
    }

    @Test
    void gameScoreIsThreeToZeroWhenFirstPlayerScoredThreePoints() {
        Match match = new Match();
        match.scorePoint(GamePlayer.FIRST);
        match.scorePoint(GamePlayer.FIRST);
        match.scorePoint(GamePlayer.FIRST);
        assertEquals(new GameScore(3, 0), match.getCurrentMatchScore());

    }
}
