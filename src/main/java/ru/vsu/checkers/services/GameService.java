package ru.vsu.checkers.services;

import ru.vsu.checkers.model.Color;
import ru.vsu.checkers.model.Game;
import ru.vsu.checkers.model.Move;
import ru.vsu.checkers.model.Player;

import java.util.List;
import java.util.Map;

public interface GameService {
    Game createGame(Map<Player, Color> playerColorMap);
    boolean doMove(Move move, Player player, Game game);
    boolean isEnd(Game game);
    Player getCurrentPlayer(Game game);
}
