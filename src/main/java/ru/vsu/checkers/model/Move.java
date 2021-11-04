package ru.vsu.checkers.model;

import lombok.Getter;

@Getter
public record Move(Cell from, Cell to) {

}
