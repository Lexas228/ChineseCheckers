package ru.vsu.checkers.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ChineseBoard {
    private Map<Figure, Cell> figureCellMap;
    private Map<Cell, Figure> cellFigureMap;

    private Map<Player, List<Cell>> playersHome;
    private Map<Player, Player> oppositePlayer;
}
