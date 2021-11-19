package ru.vsu.checkers.services;

import ru.vsu.checkers.model.logic.ChineseBoard;
import ru.vsu.checkers.model.logic.Figure;
import ru.vsu.checkers.model.logic.Player;

import java.util.Map;
import java.util.Set;

public interface BoardService {
    ChineseBoard createBoard(Map<Player, Set<Figure>> playerFigures);
}
