package ru.vsu.checkers.model.logic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Figure {
    private Color myColor;

    @Override
    public String toString(){
        return myColor.getColor() + "o" + Color.getReset();
    }
}
