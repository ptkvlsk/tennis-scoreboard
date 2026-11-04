package com.boo4er;

public class RegularGame implements Playable {

    private int firstPlayerScore;
    private int secondPlayerScore;

    @Override
    public void scorePoint(GamePlayer player) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public GamePlayer findWinner() {
        return null;
    }

    @Override
    public GameScore getScore() {
        return null;
    }
}
