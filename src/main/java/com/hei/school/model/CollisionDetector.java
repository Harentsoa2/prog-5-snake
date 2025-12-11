package com.hei.school.model;

public class CollisionDetector {


    public boolean hasHitWall(Position position) {
        int row = position.row();
        int column = position.column();

        return row <= 0 || row >= GameConstants.SCREEN_HEIGHT - 1
                || column <= 0 || column >= GameConstants.SCREEN_WIDTH - 1;
    }


    public boolean hasFoodBeenEaten(Snake snake, Food food) {
        return snake.getHead().equals(food.getPosition());
    }

    public boolean hasGameEndingCollision(Snake snake) {
        return hasHitWall(snake.getHead()) || snake.hasCollidedWithItself();
    }
}
