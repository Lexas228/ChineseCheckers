package ru.vsu.checkers.model.logic;

import lombok.Data;

@Data
public class User implements Player{
    private long id;
    private String login;
}
