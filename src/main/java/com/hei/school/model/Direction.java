package com.hei.school.model;

public enum Direction {
    LEFT(-1, 0, 'a'),
    RIGHT(1, 0, 'd'),
    UP(0, -1, 'w'),
    DOWN(0, 1, 's');

    private final int deltaColumn;
    private final int deltaRow;
    private final char keyBinding;

    Direction(int deltaColumn, int deltaRow, char keyBinding) {
        this.deltaColumn = deltaColumn;
        this.deltaRow = deltaRow;
        this.keyBinding = keyBinding;
    }

    public int getDeltaColumn() {
        return deltaColumn;
    }

    public int getDeltaRow() {
        return deltaRow;
    }

    public char getKeyBinding() {
        return keyBinding;
    }

    public Direction getOpposite() {
        switch (this) {
            case LEFT: return RIGHT;
            case RIGHT: return LEFT;
            case UP: return DOWN;
            case DOWN: return UP;
            default: throw new IllegalStateException("unknow  direction");
        }
    }


    public static Direction fromKey(char key) {
        for (Direction direction : values()) {
            if (direction.keyBinding == key) {
                return direction;
            }
        }
        return null;
    }


    public boolean isValidChange(Direction newDirection) {
        return newDirection != null && this != newDirection.getOpposite();
    }
}