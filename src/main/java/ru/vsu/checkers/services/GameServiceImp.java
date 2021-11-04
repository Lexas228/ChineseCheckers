package ru.vsu.checkers.services;

import ru.vsu.checkers.components.BotMoveValidator;
import ru.vsu.checkers.components.PlayerMoveValidator;
import ru.vsu.checkers.components.UserMoveValidator;
import ru.vsu.checkers.model.*;

import java.util.*;

public class GameServiceImp implements GameService{

    private final ChineseBoardService chineseBoardService;

    public GameServiceImp(ChineseBoardService chineseBoardService) {
        this.chineseBoardService = chineseBoardService;
    }

    @Override
    public Game createGame(Map<Player, Color> playerColorMap) {
        Game game = new Game();
        Map<Player, PlayerMoveValidator> map = new HashMap<>();
        Map<Player, Set<Figure>> playerSetMap = new HashMap<>();
        playerColorMap.forEach((key, value) -> {
            map.put(key, key instanceof User ? new UserMoveValidator(new FigureServiceImp()) : new BotMoveValidator());
            Set<Figure> figures1 = new HashSet<>();
            for(int i = 0; i < 10; i++){
                Figure f = new Figure(value);
                figures1.add(f);
            }
            playerSetMap.put(key, figures1);
        });
        ChineseBoard board = chineseBoardService.createBoard(playerSetMap);
        game.setBoard(board);
        game.setPlayerFigures(playerSetMap);
        game.setPlayerMoveValidatorMap(map);
        return game;
    }

    @Override
    public boolean doMove(Move move, Player player, Game game) {
        PlayerMoveValidator mv = game.getPlayerMoveValidatorMap().get(player);
        if(mv == null || !mv.isPossibleMove(move, player, game))return false;
        Map<Cell, Figure> cellFigureMap = game.getBoard().getCellFigureMap();
        Map<Figure, Cell> figureCellMap = game.getBoard().getFigureCellMap();
        Figure active = cellFigureMap.get(move.getFrom());
        cellFigureMap.put(move.getFrom(), null);
        cellFigureMap.put(move.getTo(), active);
        figureCellMap.put(active, move.getTo());
        updateGameStatus(game);
        return true;
    }

    @Override
    public boolean isEnd(Game game) {
        return game.getGameStatus() == GameStatus.END;
    }

    @Override
    public Player getCurrentPlayer(Game game) {
        return game.getPlayerQueue().peek();
    }

    private void updateGameStatus(Game game){

    }


}
