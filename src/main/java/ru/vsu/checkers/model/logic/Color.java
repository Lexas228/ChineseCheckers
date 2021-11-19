package ru.vsu.checkers.model.logic;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum Color {
    Yellow("\u001B[33m"),
    Blue("\u001B[34m"),
    Red("\u001B[31m"),
    Green("\u001B[32m"),
    Black("\u001B[30m"),
    Cyan("\u001B[36m");

    private String color;
    private static final String reset = "\u001B[0m";

    Color(String color){
        this.color = color;
    }

    public static String getReset(){
        return reset;
    }
}
