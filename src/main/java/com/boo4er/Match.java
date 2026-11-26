package com.boo4er;

import java.util.ArrayList;
import java.util.List;

public class Match {

    private static final int MIN_SETS_TO_WIN_MATCH = 2;

    private int firstPlayerSets;
    private int secondPlayerSets;

    private final List<GameSet> sets = new ArrayList<>();

    public Match() {
        sets.add(new GameSet());
    }

    private GameSet currentSet() {
        return sets.get(sets.size() - 1);
    }

    public void scorePoint(GamePlayer player) {

        if (isFinished()) {
            throw new IllegalStateException("Cannot score a point: the match is already finished. Sets score: "
                    + firstPlayerSets + ":" + secondPlayerSets);
        }

        currentSet().scorePoint(player);

        if (currentSet().isFinished()) {
            GamePlayer winner = currentSet().findWinner();
            if (GamePlayer.FIRST == winner) {
                firstPlayerSets = firstPlayerSets + 1;
            } else if (GamePlayer.SECOND == winner) {
                secondPlayerSets = secondPlayerSets + 1;
            }
            if (!isFinished()) {
                sets.add(new GameSet());
            }
        }
    }

    public boolean isFinished() {
        return Math.max(firstPlayerSets, secondPlayerSets) >= MIN_SETS_TO_WIN_MATCH;
    }

    public GamePlayer findWinner() {
        if (!isFinished()) {
            throw new IllegalStateException("Cannot find the winner: the match is not finished yet. Sets score: " +
                    firstPlayerSets + ":" + secondPlayerSets);
        }
        return firstPlayerSets > secondPlayerSets ? GamePlayer.FIRST : GamePlayer.SECOND;
    }

    public MatchScore getMatchScore() {
        return new MatchScore(firstPlayerSets, secondPlayerSets);
    }

    public GameScore getCurrentGameScore() {
        return currentSet().getCurrentGameScore();
    }

    public SetScore getCurrentSetScore() {
        return currentSet().getScore();
    }

    public GameType getGameType() {
        return currentSet().gameType();
    }
}
