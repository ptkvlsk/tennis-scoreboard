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
    void matchIsFinishedWhenFirstPlayerWinTwoSet() {
        Match match = new Match();
        scoreFreshSet(match, GamePlayer.FIRST);
        scoreFreshSet(match, GamePlayer.FIRST);
        assertTrue(match.isFinished());
    }
}
