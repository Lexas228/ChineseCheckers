package ru.vsu.checkers.components;

import ru.vsu.checkers.model.Game;
import ru.vsu.checkers.model.Move;
import ru.vsu.checkers.model.Player;
import ru.vsu.checkers.services.FigureService;

public class UserMoveValidator implements PlayerMoveValidator{
    private final FigureService figureService;

    public UserMoveValidator(FigureService figureService) {
        this.figureService = figureService;
    }

    @Override
    public boolean isPossibleMove(Move move, Player player, Game game) {
        return false;
    }
}
