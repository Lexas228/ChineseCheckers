package ru.vsu.checkers.controller;

import ru.vsu.checkers.components.*;
import ru.vsu.checkers.model.*;
import ru.vsu.checkers.services.GameService;
import java.util.Map;

public class ChineseGameController implements GameController{
    private final GameService gameService;

    public ChineseGameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void startGame(Map<Player, MoveGetter> map, Map<Player, Color> playerColorMap, int numOfMoves, ViewUpdater updater){
        Game game = gameService.createGame(playerColorMap);
        int nm = 0;
        while (!gameService.isEnd(game) || nm <= numOfMoves) {
            Player curr = gameService.getCurrentPlayer(game);
            MoveGetter mv = map.get(curr);
            Move m = mv.getMove(game);
            while (!gameService.doMove(m, curr, game)) {
                m = mv.getMove(game);
            }
            nm++;
            updater.updateView(game);
        }
    }
}
