package ru.vsu.checkers.model.logic;

import lombok.Data;
import ru.vsu.checkers.components.PlayerMoveValidator;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

@Data
public class Game {
    private Cell centerCell;

    private Board board;

    private Map<Player, Set<Figure>> playerFigures;

    private Map<Player, PlayerMoveValidator> playerMoveValidatorMap;

    private Queue<Player> playerQueue;

    private List<MoveInfo> listMoves;

    private GameStatus gameStatus;

    private List<MoveInfo> moveInfoList;

}
