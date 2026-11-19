package com.boo4er;

import java.util.ArrayList;
import java.util.List;

public class Match {

    private int firstPlayerSets;
    private int secondPlayerSets;

    private final List<GameSet> sets = new ArrayList<>();

    public Match() {
        sets.add(new GameSet());
    }
}
