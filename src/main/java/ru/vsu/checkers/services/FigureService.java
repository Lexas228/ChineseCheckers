package ru.vsu.checkers.services;

import ru.vsu.checkers.model.logic.Cell;
import ru.vsu.checkers.model.logic.Game;
import ru.vsu.checkers.model.logic.Move;

import java.util.List;
import java.util.Set;

public interface FigureService {
    Set<Cell> getPossibleMoves(Cell cell, Game game);
}
