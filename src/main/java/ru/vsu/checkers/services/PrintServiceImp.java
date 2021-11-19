package ru.vsu.checkers.services;

import ru.vsu.checkers.model.logic.Board;
import ru.vsu.checkers.model.logic.Cell;
import ru.vsu.checkers.model.logic.Figure;
import ru.vsu.checkers.model.logic.Game;
import ru.vsu.checkers.model.view.VisualBoard;

public class PrintServiceImp implements PrintService{
    @Override
    public void print(Game game) {
        Board board = game.getBoard();
        VisualBoard vs = board.getVisualBoard();
        System.out.println("Game status: " + game.getGameStatus());

        Cell[][] c =vs.getBoard();
        for (Cell[] cells : c) {
            for (Cell need : cells) {
                if (need == null) System.out.print("  ");
                else {
                    Figure f = board.getCellFigureMap().get(need);
                    if (f == null) System.out.print("e ");
                    else System.out.print(f + " ");
                }
            }
            System.out.println();
        }
    }
}
