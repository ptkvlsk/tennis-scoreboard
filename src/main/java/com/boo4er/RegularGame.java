package com.boo4er;

public class RegularGame extends AbstractTwoPointsLeadGame {

    private static final int MIN_POINTS_TO_WIN_GAME = 4;

    @Override
    protected int minPointsToWin() {
        return MIN_POINTS_TO_WIN_GAME;
    }

    @Override
    public GameType getGameType() {
        return GameType.REGULAR;
    }
}
