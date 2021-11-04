package ru.vsu.checkers.components;

import ru.vsu.checkers.model.Game;
import ru.vsu.checkers.model.Move;
import ru.vsu.checkers.model.Player;

public class BotMoveValidator implements PlayerMoveValidator{
    @Override
    public boolean isPossibleMove(Move move, Player player, Game game) {
        return true;
    }
}
