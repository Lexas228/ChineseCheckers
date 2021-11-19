package ru.vsu.checkers.components;

import ru.vsu.checkers.model.logic.Game;

@FunctionalInterface
public interface ViewUpdater {
    public void updateView(Game game);
}
