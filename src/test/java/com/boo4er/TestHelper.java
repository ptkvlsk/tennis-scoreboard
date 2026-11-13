package com.boo4er;

public class TestHelper {

    private static final int POINTS_TO_WIN_GAME = 4;

    static void scorePoints(Playable game, GamePlayer player, int count) {
        for (int i = 0; i < count; i++) {
            game.scorePoint(player);
        }
    }

    static void scoreGame(GameSet gameSet, GamePlayer player) {
        for (int i = 0; i < POINTS_TO_WIN_GAME; i++) {
            gameSet.scorePoint(player);
        }
    }

}
