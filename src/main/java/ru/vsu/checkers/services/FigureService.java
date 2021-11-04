package ru.vsu.checkers.services;

import ru.vsu.checkers.model.Cell;
import ru.vsu.checkers.model.Figure;
import ru.vsu.checkers.model.Game;

import java.util.List;

public interface FigureService {
    List<Cell> getPossibleMoves(Figure figure, Game game);
}
