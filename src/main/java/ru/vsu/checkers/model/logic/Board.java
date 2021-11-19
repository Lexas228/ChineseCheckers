package ru.vsu.checkers.model.logic;

import ru.vsu.checkers.model.view.VisualBoard;

import java.util.List;
import java.util.Map;

public interface Board {
    Map<Player, List<Cell>> getBasicPosition();
    Map<Player, Player> getEnemyMap();
    Map<Cell, Figure> getCellFigureMap();
    Map<Figure, Cell> getFigureCellMap();
    VisualBoard getVisualBoard();
}
