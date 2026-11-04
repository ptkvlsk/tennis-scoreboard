package com.boo4er;

public class RegularGame implements Playable {

    private int firstPlayerScore;
    private int secondPlayerScore;

    @Override
    public void scorePoint(GamePlayer player) {
        if (GamePlayer.FIRST == player) {
            firstPlayerScore = firstPlayerScore + 1;
        } else if (GamePlayer.SECOND == player) {
            secondPlayerScore = secondPlayerScore + 1;
        }
    }

    @Override
    public boolean isFinished() {
        return Math.abs(firstPlayerScore - secondPlayerScore) >= 2 && Math.max(firstPlayerScore, secondPlayerScore) >= 4;
    }

    @Override
    public GamePlayer findWinner() {
        return null;
    }

    @Override
    public GameScore getScore() {
        return new GameScore(firstPlayerScore, secondPlayerScore);
    }
}
