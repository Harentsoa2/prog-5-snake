package com.hei.school.model;


import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;

public class Snake {
    private final LinkedList<Position> body;
    private Direction currentDirection;
    private final Set<Position> bodySet;

    public Snake() {
        this.body = new LinkedList<>();
        this.bodySet = new HashSet<>();
        this.currentDirection = Direction.RIGHT;
        initializeSnake();
    }


    private void initializeSnake() {
        for (int i = 0; i < GameConstants.INITIAL_SNAKE_LENGTH; i++) {
            Position position = new Position(
                    GameConstants.INITIAL_SNAKE_ROW,
                    GameConstants.INITIAL_SNAKE_COLUMN - i
            );
            body.add(position);
            bodySet.add(position);
        }
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }


    public void changeDirection(Direction newDirection) {
        if (currentDirection.isValidChange(newDirection)) {
            this.currentDirection = newDirection;
        }
    }


    public Position getHead() {
        return body.getFirst();
    }


    public void move(boolean grow) {
        Position newHead = getHead().move(currentDirection);
        body.addFirst(newHead);
        bodySet.add(newHead);

        if (!grow) {
            Position tail = body.removeLast();
            bodySet.remove(tail);
        }
    }


    public boolean hasCollidedWithItself() {
        Position head = getHead();
        int count = 0;
        for (Position position : body) {
            if (position.equals(head)) {
                count++;
                if (count > 1) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean occupies(Position position) {
        return bodySet.contains(position);
    }

    public LinkedList<Position> getBody() {
        return new LinkedList<>(body);
    }

    public int getLength() {
        return body.size();
    }
}
