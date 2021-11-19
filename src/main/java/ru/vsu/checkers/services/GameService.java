package ru.vsu.checkers.services;

import ru.vsu.checkers.components.MoveGetter;
import ru.vsu.checkers.components.ViewUpdater;
import ru.vsu.checkers.model.logic.Color;
import ru.vsu.checkers.model.logic.Game;
import ru.vsu.checkers.model.logic.Move;
import ru.vsu.checkers.model.logic.Player;

import java.util.Map;

public interface GameService {
    Game createGame(Map<Player, Color> playerColorMap);
    boolean doMove(Move move, Player player, Game game);
    boolean isEnd(Game game);
    Player getCurrentPlayer(Game game);
    void startGame(Map<Player, MoveGetter> map, int numOfMoves, ViewUpdater updater, Game game);
}
