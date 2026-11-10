package com.boo4er;

public class GameTestHelper {

    static void scorePoints(Playable game, GamePlayer player, int count) {
        for (int i = 0; i < count; i++) {
            game.scorePoint(player);
        }
    }
}
