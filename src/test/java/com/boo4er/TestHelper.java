package com.boo4er;

public class TestHelper {

    private static final int POINTS_TO_WIN_GAME = 4;
    private static final int POINTS_TO_WIN_TIE_BREAK = 7;
    private static final int POINTS_TO_WIN_SET = 24;

    static void scorePoints(Playable game, GamePlayer player, int count) {
        for (int i = 0; i < count; i++) {
            game.scorePoint(player);
        }
    }

    static void scoreFreshGame(GameSet gameSet, GamePlayer player) {
        for (int i = 0; i < POINTS_TO_WIN_GAME; i++) {
            gameSet.scorePoint(player);
        }
    }

    static void scoreFreshTieBreak(GameSet gameSet, GamePlayer player) {
        for (int i = 0; i < POINTS_TO_WIN_TIE_BREAK; i++) {
            gameSet.scorePoint(player);
        }
    }

    static void scoreFreshSet(Match match, GamePlayer player) {
        for (int i = 0; i < POINTS_TO_WIN_SET; i++) {
            match.scorePoint(player);
        }
    }
}
