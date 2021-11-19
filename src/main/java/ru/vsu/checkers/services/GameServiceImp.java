package ru.vsu.checkers.services;

import ru.vsu.checkers.components.*;
import ru.vsu.checkers.model.logic.*;

import java.util.*;

public class GameServiceImp implements GameService{

    private final BoardService boardService;
    private final FigureService figureService;

    public GameServiceImp() {
        this.boardService = new ChineseBoardService();
        this.figureService = new FigureServiceImp();

    }

    @Override
    public Game createGame(Map<Player, Color> playerColorMap) {
        Game game = new Game();
        Map<Player, PlayerMoveValidator> map = new HashMap<>();
        Map<Player, Set<Figure>> playerSetMap = new HashMap<>();
        Queue<Player> playerQueue = new LinkedList<>();
        playerColorMap.forEach((key, value) -> {
            map.put(key, key instanceof User ? new UserMoveValidator(new FigureServiceImp()) : new BotMoveValidator());
            Set<Figure> figures1 = new HashSet<>();
            for(int i = 0; i < 10; i++){
                Figure f = new Figure(value);
                figures1.add(f);
            }
            playerSetMap.put(key, figures1);
            playerQueue.add(key);
        });
        Board board = boardService.createBoard(playerSetMap);
        game.setBoard(board);
        game.setPlayerFigures(playerSetMap);
        game.setPlayerMoveValidatorMap(map);
        game.setGameStatus(GameStatus.OK);
        game.setPlayerQueue(playerQueue);
        return game;
    }

    @Override
    public boolean doMove(Move move, Player player, Game game) {
        PlayerMoveValidator mv = game.getPlayerMoveValidatorMap().get(player);
        if(mv == null || !mv.isPossibleMove(move, player, game))return false;
        Map<Cell, Figure> cellFigureMap = game.getBoard().getCellFigureMap();
        Map<Figure, Cell> figureCellMap = game.getBoard().getFigureCellMap();
        Figure active = cellFigureMap.get(move.from());
        cellFigureMap.put(move.from(), null);
        cellFigureMap.put(move.to(), active);
        figureCellMap.put(active, move.to());
        game.getPlayerQueue().add(game.getPlayerQueue().poll());
        return true;
    }

    @Override
    public void startGame(Map<Player, MoveGetter> map, int numOfMoves, ViewUpdater updater, Game game){
        int nm = 0;
        while (!isEnd(game) && nm <= numOfMoves) {
            Player curr = getCurrentPlayer(game);
            MoveGetter mv = map.get(curr);
            Move m = mv.getMove(game, curr);
            while (!doMove(m, curr, game)) {
                m = mv.getMove(game, curr);
            }
            nm++;
            updateGameStatus(game);
            updater.updateView(game);
        }
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
        Player curr = game.getPlayerQueue().peek();
        if(isAllInTarget(game, curr)){
            game.setGameStatus(GameStatus.END);
        }
        if(hasNoMoves(game, curr)){
            game.setGameStatus(GameStatus.END);
        }
    }

    private boolean hasNoMoves(Game game, Player player){
        Set<Figure> figures = game.getPlayerFigures().get(player);
        for(Figure figure : figures){
            Cell c = game.getBoard().getFigureCellMap().get(figure);
            Set<Cell> availableMoves = figureService.getPossibleMoves(c, game);
            if(!availableMoves.isEmpty())return false;
        }
        return true;
    }

    private boolean isAllInTarget(Game game, Player player){
        Player opponent = game.getBoard().getEnemyMap().get(player);
        List<Cell> basicOpponentCells = game.getBoard().getBasicPosition().get(opponent);
        Set<Figure> figures = game.getPlayerFigures().get(player);
        for(Figure figure : figures){
            Cell c = game.getBoard().getFigureCellMap().get(figure);
            if(!basicOpponentCells.contains(c))return false;
        }
        return true;
    }


}
