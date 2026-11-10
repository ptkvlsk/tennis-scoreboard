package com.boo4er;

public class TieBreakGame extends AbstractTwoPointsLeadGame {

    private static final int MIN_POINTS_TO_WIN_GAME = 7;

    @Override
    protected int minPointsToWin() {
        return MIN_POINTS_TO_WIN_GAME;
    }
}
