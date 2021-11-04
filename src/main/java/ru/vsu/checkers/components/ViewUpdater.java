package ru.vsu.checkers.components;

import ru.vsu.checkers.model.Game;

@FunctionalInterface
public interface ViewUpdater {
    public void updateView(Game game);
}
