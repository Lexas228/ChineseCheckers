package ru.vsu.checkers.components;

import ru.vsu.checkers.model.Game;
import ru.vsu.checkers.model.Move;

@FunctionalInterface
public interface MoveGetter {
    Move getMove(Game game);
}
