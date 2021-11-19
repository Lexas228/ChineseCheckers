package ru.vsu.checkers.services;

import ru.vsu.checkers.model.logic.*;
import ru.vsu.checkers.model.view.VisualBoard;

import java.util.*;

public class ChineseBoardService implements BoardService{

    @Override
    public ChineseBoard createBoard(Map<Player, Set<Figure>> playerFigures) {
        ChineseBoard board = new ChineseBoard();
        Map<Cell, Figure> cellFigureMap = new HashMap<>();
        Map<Figure, Cell> figureCellMap = new HashMap<>();
        Map<Player, Player> oppositePlayers = new HashMap<>();
        Map<Player, List<Cell>> playerHomes = new HashMap<>();
        board.setCellFigureMap(cellFigureMap);
        board.setEnemyMap(oppositePlayers);
        board.setFigureCellMap(figureCellMap);
        board.setPlayersBasicCells(playerHomes);
        List<Player> playerList = new ArrayList<>();
        Map<Direction, List<Cell>> homes = createBoard(board);
        Direction[] directions = Direction.values();
        int currDirection = 0;
        int numOfPlayers = playerFigures.size();
        int h = numOfPlayers >> 1;
        for(var l : playerFigures.entrySet()){
            playerList.add(l.getKey());
            List<Cell> curr = homes.get(directions[currDirection]);
            playerHomes.put(l.getKey(), curr);
            if(playerList.size() >= h){
                Player opp = playerList.get(playerList.size()-h);
                oppositePlayers.put(opp, l.getKey());
                oppositePlayers.put(l.getKey(), opp);
            }
            int k = 0;
            for(Figure f : l.getValue()){
                Cell c = curr.get(k);
                cellFigureMap.put(c, f);
                figureCellMap.put(f, c);
                k++;
            }
            currDirection++;
        }
        return board;
    }

    private Map<Direction, List<Cell>> createBoard(ChineseBoard board){
        VisualBoard vb = new VisualBoard();
        Cell[][] c= new Cell[17][25];
        vb.setBoard(c);
        board.setVisualBoard(vb);
        Map<Direction, List<Cell>> homes = new HashMap<>();
        for(Direction d : Direction.values()){
            homes.put(d, new ArrayList<>());
        }
        List<Integer> starts = List.of(12, 11, 10, 9, 0, 1, 2, 3, 4, 3, 2, 1, 0, 9, 10, 11, 12);
        List<Integer> ends = List.of(13, 14, 15, 16, 24, 23, 22, 21, 20, 21, 22, 23, 24, 16, 15, 14, 13);
        for(int i = 0; i < c.length; i++){
            for(int j = starts.get(i); j <= ends.get(i); j++){
                if(canCreateCell(i, j)){
                    c[i][j] = new Cell();
                    createConnection(i, j, c);
                    Direction direction = getDirectionOfHome(i, j);
                    if(direction != null){
                        homes.get(direction).add(c[i][j]);
                    }
                }
            }
        }
        return homes;
    }

    private Direction getDirectionOfHome(int i, int j){
        if(i < 4)return Direction.NorthEast;
        if(i == 4 && j < 7 || i==5 && j < 6 || i == 6 && j < 5 || i == 7 && j < 4)return Direction.NorthWest;
        if(i == 4 && j >17 || i == 5 && j > 18 || i==6 && j > 19 || i==7 && j > 20) return Direction.East;
        if(i == 9 && j < 4 || i==10 && j< 5 || i==11 && j < 6 || i==12 && j < 7)return Direction.West;
        if(i == 9 && j >20 || i==10 && j >19 || i==11 && j >18 || i==12 && j >17) return Direction.SouthEast;
        if(i > 12) return Direction.SouthWest;
      return null;
    }

    private boolean canCreateCell(int i, int j){
        return (i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j %2 != 0);
    }

    private void createConnection(int currI, int currJ, Cell[][] cells){
        if(cells[currI][currJ] != null){
            Cell main = cells[currI][currJ];
            if(currI - 1 >= 0 && currJ-1 >= 0 && cells[currI-1][currJ-1] != null){
                Cell leftUp = cells[currI-1][currJ-1];
                main.getCells().put(Direction.NorthWest, leftUp);
                leftUp.getCells().put(Direction.SouthEast, main);
            }
            if(currI-1 >=0 && currJ+1 < cells[currI-1].length && cells[currI-1][currJ+1] != null){
                Cell rightUp = cells[currI-1][currJ+1];
                main.getCells().put(Direction.NorthEast, rightUp);
                rightUp.getCells().put(Direction.SouthWest, main);
            }
            if(currJ-2 >= 0 && cells[currI][currJ-2] != null){
                Cell last = cells[currI][currJ-2];
                last.getCells().put(Direction.East, main);
                main.getCells().put(Direction.West, last);
            }
        }
    }
}
