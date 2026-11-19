package com.boo4er;

import org.junit.jupiter.api.Test;

import static com.boo4er.TestHelper.scoreFreshGame;
import static com.boo4er.TestHelper.scoreFreshTieBreak;
import static org.junit.jupiter.api.Assertions.*;

public class GameSetTest {

    @Test
    void setScoreIsOneToZeroWhenFirstPlayerScoredFourPoints() {
        GameSet gameSet = new GameSet();
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        assertEquals(new SetScore(1, 0), gameSet.getScore());
    }

    @Test
    void setScoreIsTwoToZeroWhenFirstPlayerWinTwoScore() {
        GameSet gameSet = new GameSet();
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        assertEquals(new SetScore(2, 0), gameSet.getScore());
    }

    @Test
    void setIsFinishedWhenFirstPlayerWinSet() {
        GameSet gameSet = new GameSet();
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        assertTrue(gameSet.isFinished());
    }

    @Test
    void setIsFinishedWhenFirstPlayerWinSixGamesAndSecondPlayerWinFourGames() {
        GameSet gameSet = new GameSet();
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        assertTrue(gameSet.isFinished());
    }

    @Test
    void setIsNotFinishedWhenFirstPlayerWinSixGamesAndSecondPlayerWinFiveGames() {
        GameSet gameSet = new GameSet();
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        assertFalse(gameSet.isFinished());
    }

    @Test
    void setIsNotFinishedWhenFirstPlayerWinFiveGamesAndSecondPlayerWinFiveGames() {
        GameSet gameSet = new GameSet();
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        assertFalse(gameSet.isFinished());
    }

    @Test
    void setIsFinishedWhenFirstPlayerWinSevenGamesAndSecondPlayerWinFiveGames() {
        GameSet gameSet = new GameSet();
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        assertTrue(gameSet.isFinished());
    }

    @Test
    void setIsFinishedWhenSecondPlayerWinSet() {
        GameSet gameSet = new GameSet();
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        assertTrue(gameSet.isFinished());
    }

    @Test
    void scorePointThrowsExceptionWhenSetIsFinished() {
        GameSet gameSet = new GameSet();
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        assertThrows(IllegalStateException.class, () -> gameSet.scorePoint(GamePlayer.FIRST));
    }

    @Test
    void gameTypeRegularTieBreakIsNotStartedWhenFirstPlayerWinFiveGamesAndSecondPlayerWinFiveGames() {
        GameSet gameSet = new GameSet();
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        assertEquals(GameType.REGULAR, gameSet.gameType());

    }

    @Test
    void gameTypeTieBreakIsStartedWhenFirstPlayerWinSixGamesAndSecondPlayerWinSixGames() {
        GameSet gameSet = new GameSet();
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        assertEquals(GameType.TIE_BREAK, gameSet.gameType());
    }

    @Test
    void setIsFinishedWhenFirstPlayerWinTieBreak() {
        GameSet gameSet = new GameSet();
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshTieBreak(gameSet, GamePlayer.FIRST);
        assertTrue(gameSet.isFinished());
    }

    @Test
    void setIsFinishedWhenSecondPlayerWinTieBreak() {
        GameSet gameSet = new GameSet();
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.SECOND);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshTieBreak(gameSet, GamePlayer.SECOND);
        assertTrue(gameSet.isFinished());
    }
}
