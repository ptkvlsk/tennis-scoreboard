package com.boo4er;

public interface Playable {

      void scorePoint(GamePlayer player);

      boolean isFinished();

      GamePlayer findWinner();

      GameScore getScore();
}
