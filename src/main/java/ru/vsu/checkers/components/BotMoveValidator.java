package ru.vsu.checkers.components;

import ru.vsu.checkers.model.logic.Game;
import ru.vsu.checkers.model.logic.Move;
import ru.vsu.checkers.model.logic.Player;

public class BotMoveValidator implements PlayerMoveValidator{
    @Override
    public boolean isPossibleMove(Move move, Player player, Game game) {
        return true;
    }
}
