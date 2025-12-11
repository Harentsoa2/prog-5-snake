package com.hei.school.model;

public class GameRenderer {


    public void render(Snake snake, Food food, int score) {
        clearScreen();
        String screen = buildScreen(snake, food);
        System.out.println(screen);
        System.out.println("Score: " + score);
    }


    public void renderGameOver(int score) {
        System.out.println("\n=================================");
        System.out.println("         GAME OVER");
        System.out.println("=================================");
        System.out.println("Score final: " + score);
        System.out.println("=================================\n");
    }


    private String buildScreen(Snake snake, Food food) {
        StringBuilder screen = new StringBuilder();

        for (int row = 0; row < GameConstants.SCREEN_HEIGHT; row++) {
            for (int column = 0; column < GameConstants.SCREEN_WIDTH; column++) {
                Position currentPosition = new Position(row, column);
                char charToDraw = determineCharAt(currentPosition, snake, food);
                screen.append(charToDraw);
            }
            screen.append('\n');
        }

        return screen.toString();
    }


    private char determineCharAt(Position position, Snake snake, Food food) {

        if (food.isAt(position)) {
            return GameConstants.FOOD_CHAR;
        }


        if (snake.occupies(position)) {
            return GameConstants.SNAKE_CHAR;
        }

        if (isWall(position)) {
            return GameConstants.WALL_CHAR;
        }


        return GameConstants.EMPTY_CHAR;
    }

    private boolean isWall(Position position) {
        int row = position.row();
        int column = position.column();

        return row == 0 || row == GameConstants.SCREEN_HEIGHT - 1
                || column == 0 || column == GameConstants.SCREEN_WIDTH - 1;
    }


    private void clearScreen() {
        System.out.print(GameConstants.CLEAR_SCREEN);
        System.out.flush();
    }
}
