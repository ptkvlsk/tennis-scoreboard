package com.boo4er;

import org.junit.jupiter.api.Test;

import static com.boo4er.TestHelper.scoreFreshSet;
import static org.junit.jupiter.api.Assertions.*;

public class MatchGameTest {

    @Test
    void matchIsNotFinishedWhenFirstPlayerWinOneSet() {
        Match match = new Match();
        scoreFreshSet(match, GamePlayer.FIRST);
        assertFalse(match.isFinished());
    }
}
