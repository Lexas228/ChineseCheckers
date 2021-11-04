package ru.vsu.checkers.components;

import ru.vsu.checkers.model.Game;
import ru.vsu.checkers.model.Move;
import ru.vsu.checkers.services.FigureService;

public class BotMoveGetter implements MoveGetter{
    private final FigureService figureService;

    public BotMoveGetter(FigureService figureService) {
        this.figureService = figureService;
    }

    @Override
    public Move getMove(Game game) {
        return null;
    }

}
