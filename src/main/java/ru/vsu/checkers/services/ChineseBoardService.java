package ru.vsu.checkers.services;

import ru.vsu.checkers.model.*;

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
        board.setOppositePlayer(oppositePlayers);
        board.setFigureCellMap(figureCellMap);
        board.setPlayersHome(playerHomes);
        List<Player> playerList = new ArrayList<>();
        List<List<Cell>> homes = new ArrayList<>();
        int numOfPlayers = playerFigures.size();
        int h = numOfPlayers >> 1;
        for(var l : playerFigures.entrySet()){
            playerList.add(l.getKey());
            List<Cell> home = createHome(6, 4);
            homes.add(home);
            playerHomes.put(l.getKey(), home);
            if(playerList.size() >= h){
                Player opp = playerList.get(playerList.size()-h);
                oppositePlayers.put(opp, l.getKey());
                oppositePlayers.put(l.getKey(), opp);
            }
            int k = 0;
            for(Figure f : l.getValue()){
                Cell c = home.get(k);
                cellFigureMap.put(c, f);
                figureCellMap.put(f, c);
            }
        }
        createCenter(homes);
        return board;
    }

    private void createCenter(List<List<Cell>> homes){

    }

    private List<Cell> createHome(int width, int height){
        Cell[][] c = new Cell[width][height];
        List<Cell> answer = new ArrayList<>();
        int start = width >> 1;
        int numOfStand = 1;
        for(int i = 0; i < c.length; i++){
            int nof = numOfStand;
            for(int j = 0; j < c[i].length; j++){
                if(canCreateCell(i, j))
                    if(j >= start && nof > 0){
                        c[i][j] = new Cell();
                        createConnection(i, j, c);
                        answer.add(c[i][j]);
                        nof--;
                    }
            }
            start--;
        }
        return answer;
    }

    private boolean canCreateCell(int i, int j){
        return (i % 2 == 0 && j % 2 != 0) || (i % 2 != 0 && j %2 == 0);
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
            if(currJ-2 > 0 && cells[currI][currJ] != null){
                Cell last = cells[currI][currJ-2];
                last.getCells().put(Direction.East, main);
                main.getCells().put(Direction.West, last);
            }

        }
    }
}
