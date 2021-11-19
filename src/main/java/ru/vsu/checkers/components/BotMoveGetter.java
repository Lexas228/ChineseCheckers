package ru.vsu.checkers.components;

import ru.vsu.checkers.model.logic.*;
import ru.vsu.checkers.services.FigureService;
import ru.vsu.checkers.services.FigureServiceImp;

import java.nio.channels.CancelledKeyException;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BotMoveGetter implements MoveGetter{
    private final FigureService figureService;
    private static final Random RND = new Random();

    public BotMoveGetter() {
        this.figureService = new FigureServiceImp();
    }

    @Override
    public Move getMove(Game game, Player forWho) {
        Set<Figure> myFigures = game.getPlayerFigures().get(forWho);
        Figure random = getRandom(myFigures);
        Cell itsCell = game.getBoard().getFigureCellMap().get(random);
        Set<Cell> possible = figureService.getPossibleMoves(itsCell, game);
        while(possible.isEmpty()){
            random = getRandom(myFigures);
            itsCell = game.getBoard().getFigureCellMap().get(random);
            possible = figureService.getPossibleMoves(itsCell, game);
        }
        Cell randomCell = getRandom(possible);
        return new Move(itsCell, randomCell);
    }

    private <T> T getRandom(Set<T> set){
        int rand = RND.nextInt(set.size());
        T answer = null;
        int k = 0;
        for(T f : set){
            answer = f;
            k++;
            if(k >= rand) break;
        }

        return answer;
    }

}
