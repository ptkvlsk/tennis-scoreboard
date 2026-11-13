package com.boo4er;

public abstract class AbstractTwoPointsLeadGame implements Playable {
    private static final int MIN_LEAD_POINTS_TO_WIN_GAME = 2;
    private int firstPlayerScore;
    private int secondPlayerScore;

    protected abstract int minPointsToWin();

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
                && Math.max(firstPlayerScore, secondPlayerScore) >= minPointsToWin();
    }

    @Override
    public GamePlayer findWinner() {
        if (!isFinished()) {
            throw new IllegalStateException("Cannot find the winner: the game is not finished yet. Score: "
                    + firstPlayerScore + ":" + secondPlayerScore);
        }
        return firstPlayerScore > secondPlayerScore ? GamePlayer.FIRST : GamePlayer.SECOND;
    }

    @Override
    public GameScore getScore() {
        return new GameScore(firstPlayerScore, secondPlayerScore);
    }
}
