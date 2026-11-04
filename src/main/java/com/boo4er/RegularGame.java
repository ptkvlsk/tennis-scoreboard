package com.boo4er;

public class RegularGame implements Playable {

    private static final int MIN_POINTS_TO_WIN_GAME = 4;
    private static final int MIN_LEAD_POINTS_TO_WIN_GAME = 2;
    private int firstPlayerScore;
    private int secondPlayerScore;

    @Override
    public void scorePoint(GamePlayer player) {

        if (isFinished()) {
            throw new IllegalStateException("Cannot score a point: the game is already finished. Score: "
                    + firstPlayerScore + ":" + secondPlayerScore);
        }

        if (GamePlayer.FIRST == player) {
            firstPlayerScore = firstPlayerScore + 1;
        } else if (GamePlayer.SECOND == player) {
            secondPlayerScore = secondPlayerScore + 1;
        }
    }

    @Override
    public boolean isFinished() {
        return Math.abs(firstPlayerScore - secondPlayerScore) >= MIN_LEAD_POINTS_TO_WIN_GAME
                && Math.max(firstPlayerScore, secondPlayerScore) >= MIN_POINTS_TO_WIN_GAME;
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
