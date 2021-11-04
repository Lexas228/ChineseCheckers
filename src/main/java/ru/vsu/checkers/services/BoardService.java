package ru.vsu.checkers.services;

import ru.vsu.checkers.model.ChineseBoard;
import ru.vsu.checkers.model.Figure;
import ru.vsu.checkers.model.Player;

import java.util.Map;
import java.util.Set;

public interface BoardService {
    ChineseBoard createBoard(Map<Player, Set<Figure>> playerFigures);
}
