package com.boo4er;

import org.junit.jupiter.api.Test;

import static com.boo4er.TestHelper.scoreGame;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameSetTest {

    @Test
    void setScoreIsOneToZeroWhenFirstPlayerScoredFourPoints() {
        GameSet gameSet = new GameSet();
        scoreGame(gameSet, GamePlayer.FIRST);
        assertEquals(new SetScore(1, 0), gameSet.getScore());
    }

    @Test
    void setScoreIsTwoToZeroWhenFirstPlayerScoredEightPoints() {
        GameSet gameSet = new GameSet();
        scoreGame(gameSet, GamePlayer.FIRST);
        scoreGame(gameSet, GamePlayer.FIRST);
        assertEquals(new SetScore(2, 0), gameSet.getScore());
    }
}
