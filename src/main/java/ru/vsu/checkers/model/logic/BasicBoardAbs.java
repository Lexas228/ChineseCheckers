package ru.vsu.checkers.model.logic;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.vsu.checkers.model.view.VisualBoard;

import java.util.List;
import java.util.Map;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BasicBoardAbs implements Board{
    private Map<Figure, Cell> figureCellMap;
    private Map<Cell, Figure> cellFigureMap;
    private Map<Player, List<Cell>> playersBasicCells;
    private Map<Player, Player> enemyMap;
    private VisualBoard visualBoard;

    @Override
    public VisualBoard getVisualBoard() {
        return visualBoard;
    }

    @Override
    public Map<Player, List<Cell>> getBasicPosition() {
        return playersBasicCells;
    }

    @Override
    public Map<Player, Player> getEnemyMap() {
        return enemyMap;
    }

    @Override
    public Map<Cell, Figure> getCellFigureMap() {
        return cellFigureMap;
    }

    @Override
    public Map<Figure, Cell> getFigureCellMap() {
        return figureCellMap;
    }
}
