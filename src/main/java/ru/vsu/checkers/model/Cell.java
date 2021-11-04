package ru.vsu.checkers.model;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Cell {
    private final Map<Direction, Cell> cells;

    public Cell() {
        cells = new HashMap<>();
        for(Direction d : Direction.values()){
            cells.put(d, null);
        }
    }

}
