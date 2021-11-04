package ru.vsu.checkers.components;

import ru.vsu.checkers.model.Game;
import ru.vsu.checkers.model.Move;
import ru.vsu.checkers.model.Player;

@FunctionalInterface
public interface PlayerMoveValidator {
    boolean isPossibleMove(Move move, Player player, Game game);
}
