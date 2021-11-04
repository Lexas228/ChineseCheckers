package ru.vsu.checkers.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum Color {
    White("White"),
    Blue("Blue"),
    Red("Red"),
    Green("Green");

    private String color;

    Color(String color){
        this.color = color;
    }

}
