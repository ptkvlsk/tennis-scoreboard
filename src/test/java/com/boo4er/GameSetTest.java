package com.boo4er;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameSetTest {

    @Test
    void setScoreIsOneToZeroWhenFirstPlayerScoredFourPoints() {
        GameSet gameSet = new GameSet();
        gameSet.scorePoint(GamePlayer.FIRST);
        gameSet.scorePoint(GamePlayer.FIRST);
        gameSet.scorePoint(GamePlayer.FIRST);
        gameSet.scorePoint(GamePlayer.FIRST);
        assertEquals(new SetScore(1, 0), gameSet.getScore());

    }
}
