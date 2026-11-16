package com.boo4er;

import org.junit.jupiter.api.Test;

import static com.boo4er.TestHelper.scoreFreshGame;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameSetTest {

    @Test
    void setScoreIsOneToZeroWhenFirstPlayerScoredFourPoints() {
        GameSet gameSet = new GameSet();
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        assertEquals(new SetScore(1, 0), gameSet.getScore());
    }

    @Test
    void setScoreIsTwoToZeroWhenFirstPlayerWinTwoSet() {
        GameSet gameSet = new GameSet();
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        scoreFreshGame(gameSet, GamePlayer.FIRST);
        assertEquals(new SetScore(2, 0), gameSet.getScore());
    }
}
