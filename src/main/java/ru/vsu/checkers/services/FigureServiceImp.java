package ru.vsu.checkers.services;

import ru.vsu.checkers.model.logic.*;

import java.util.*;

public class FigureServiceImp implements FigureService {
    @Override
    public Set<Cell> getPossibleMoves(Cell cell, Game game) {
        Set<Cell> answer = new HashSet<>();
        Stack<Cell> stack = new Stack<>();
        for(Direction d : Direction.values()){
            Cell need = cell.getCells().get(d);
            if(need != null){
                Figure f = game.getBoard().getCellFigureMap().get(need);
                if(f == null){
                    answer.add(need);
                }else{
                    Cell afterJump = tryToJump(cell, d, game);
                    if(afterJump != null){
                        stack.push(afterJump);
                        answer.add(afterJump);
                    }
                }
            }
        }

        while(!stack.empty()){
            Cell curr = stack.pop();
            for(Direction d : Direction.values()){
                Cell after = tryToJump(curr, d, game);
                if(after != null && !answer.contains(after)){
                    stack.add(after);
                    answer.add(after);
                }
            }
        }

        return answer;
    }

    private Cell tryToJump(Cell from, Direction direction, Game game){
        Cell next = from.getCells().get(direction);
        if(next != null){
            Figure f = game.getBoard().getCellFigureMap().get(next);
            if(f != null){
                Cell nextNext = next.getCells().get(direction);
                if(nextNext != null){
                    Figure fig = game.getBoard().getCellFigureMap().get(nextNext);
                    if(fig == null){
                        return nextNext;
                    }
                }
            }
        }
        return null;
    }
}
