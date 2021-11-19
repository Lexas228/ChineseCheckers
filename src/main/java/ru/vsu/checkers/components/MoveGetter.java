package ru.vsu.checkers.components;

import ru.vsu.checkers.model.logic.Game;
import ru.vsu.checkers.model.logic.Move;
import ru.vsu.checkers.model.logic.Player;

@FunctionalInterface
public interface MoveGetter{
    Move getMove(Game game, Player forWho);
}
