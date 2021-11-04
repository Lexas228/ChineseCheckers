package ru.vsu.checkers.model;

import lombok.Data;
import ru.vsu.checkers.components.MoveGetter;
import ru.vsu.checkers.components.PlayerMoveValidator;

@Data
public class PlayerInformation {
    private final PlayerMoveValidator moveValidator;
    private final MoveGetter moveGetter;
}
