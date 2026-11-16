package com.boo4er;

import java.util.ArrayList;
import java.util.List;

public class GameSet {

    private static final int MIN_LEAD_GAME_TO_WIN_SET = 2;
    private static final int MIN_GAME_TO_WIN_SET = 6;
    private int firstPlayerGames;
    private int secondPlayerGames;

    private final List<Playable> games = new ArrayList<>();

    public GameSet() {
        games.add(new RegularGame());
    }

    private Playable currentGame() {
        return games.get(games.size() - 1);
    }

    public void scorePoint(GamePlayer player) {

        if (isFinished()) {
            throw new IllegalStateException("Cannot score a point: the set is already finished. Games: "
                    + firstPlayerGames + ":" + secondPlayerGames);
        }

        currentGame().scorePoint(player);

        if (currentGame().isFinished()) {
            GamePlayer winner = currentGame().findWinner();
            if (GamePlayer.FIRST == winner) {
                firstPlayerGames = firstPlayerGames + 1;
            } else if (GamePlayer.SECOND == winner) {
                secondPlayerGames = secondPlayerGames + 1;
            }
            games.add(new RegularGame());
        }
    }

    public SetScore getScore() {
        return new SetScore(firstPlayerGames, secondPlayerGames);
    }

    public boolean isFinished() {
        return Math.abs(firstPlayerGames - secondPlayerGames) >= MIN_LEAD_GAME_TO_WIN_SET
                && Math.max(firstPlayerGames, secondPlayerGames) >= MIN_GAME_TO_WIN_SET;
    }

}
