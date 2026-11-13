package com.boo4er;

import java.util.List;
import java.util.ArrayList;

public class GameSet {
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
        currentGame().scorePoint(player);
        if (currentGame().isFinished()) {
            GamePlayer winner = currentGame().findWinner();
            if (GamePlayer.FIRST == winner) {
                firstPlayerGames = firstPlayerGames + 1;
            } else if (GamePlayer.SECOND == winner) {
                secondPlayerGames = secondPlayerGames + 1;
            }
        }
    }

    public SetScore getScore() {
        return new SetScore(firstPlayerGames, secondPlayerGames);
    }
}
