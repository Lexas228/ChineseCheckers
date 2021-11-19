package ru.vsu.checkers.model.view;

import lombok.Data;
import ru.vsu.checkers.model.logic.Cell;
import ru.vsu.checkers.model.logic.Color;

import java.util.Map;

@Data
public class VisualBoard {
    private Cell[][] board;
}
