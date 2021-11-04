package ru.vsu.checkers.services;

import ru.vsu.checkers.model.Cell;
import ru.vsu.checkers.model.Figure;
import ru.vsu.checkers.model.Game;

import java.util.List;

public class FigureServiceImp implements FigureService {
    @Override
    public List<Cell> getPossibleMoves(Figure figure, Game game) {
        Cell c = game.getBoard().getFigureCellMap().get(figure);
        return null;
    }
}
