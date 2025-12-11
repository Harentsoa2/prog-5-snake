package com.hei.school.model;

public final class GameConstants {

    public static final int SCREEN_HEIGHT = 20;
    public static final int SCREEN_WIDTH = 40;


    public static final int TICK_DELAY = 120;



    public static final int INITIAL_SNAKE_ROW = 10;
    public static final int INITIAL_SNAKE_COLUMN = 10;
    public static final int INITIAL_SNAKE_LENGTH = 3;


    public static final char WALL_CHAR = 'X';
    public static final char SNAKE_CHAR = '#';
    public static final char FOOD_CHAR = '*';
    public static final char EMPTY_CHAR = ' ';


    public static final String CLEAR_SCREEN = "\033[H\033[2J";


    public static final int MIN_PLAYABLE_ROW = 1;
    public static final int MAX_PLAYABLE_ROW = SCREEN_HEIGHT - 2;
    public static final int MIN_PLAYABLE_COLUMN = 1;
    public static final int MAX_PLAYABLE_COLUMN = SCREEN_WIDTH - 2;

    private GameConstants() {
        throw new AssertionError("class must be instantiated");
    }
}