package com.boo4er;

import java.util.UUID;

public record LiveMatch(UUID matchId, String firstPlayerName, String secondPlayerName, Match match)  {
}
