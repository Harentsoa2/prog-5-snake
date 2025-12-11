package com.hei.school.model;

import java.util.Random;


public class Food {
    private Position position;
    private final Random random;

    public Food() {
        this.random = new Random();
        this.position = generateRandomPosition();
    }

    public Position getPosition() {
        return position;
    }

    public void regenerate() {
        this.position = generateRandomPosition();
    }

    private Position generateRandomPosition() {
        int row = random.nextInt(GameConstants.MAX_PLAYABLE_ROW)
                + GameConstants.MIN_PLAYABLE_ROW;
        int column = random.nextInt(GameConstants.MAX_PLAYABLE_COLUMN)
                + GameConstants.MIN_PLAYABLE_COLUMN;
        return new Position(row, column);
    }

    public boolean isAt(Position position) {
        return this.position.equals(position);
    }
}