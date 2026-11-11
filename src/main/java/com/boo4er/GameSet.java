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
}
