package com.hei.school.model;


public class Game {
    private final Snake snake;
    private final Food food;
    private final GameRenderer renderer;
    private final InputHandler inputHandler;
    private final CollisionDetector collisionDetector;
    private GameState gameState;
    private int score;

    public Game() {
        this.snake = new Snake();
        this.food = new Food();
        this.renderer = new GameRenderer();
        this.inputHandler = new InputHandler();
        this.collisionDetector = new CollisionDetector();
        this.gameState = GameState.RUNNING;
        this.score = 0;
    }


    public void start() {
        try {
            while (gameState == GameState.RUNNING) {
                handleInput();
                update();
                render();
                waitForNextTick();
            }
        } finally {
            inputHandler.stop();
            renderer.renderGameOver(score);
        }
    }

    private void handleInput() {
        Direction newDirection = inputHandler.readInput();
        if (newDirection != null) {
            snake.changeDirection(newDirection);
        }
    }


    private void update() {
        boolean hasEaten = collisionDetector.hasFoodBeenEaten(snake, food);

        snake.move(hasEaten);

        if (hasEaten) {
            score++;
            food.regenerate();
        }

        if (collisionDetector.hasGameEndingCollision(snake)) {
            gameState = GameState.GAME_OVER;
        }
    }


    private void render() {
        renderer.render(snake, food, score);
    }

    private void waitForNextTick() {
        try {
            Thread.sleep(GameConstants.TICK_DELAY);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            gameState = GameState.GAME_OVER;
        }
    }

    public int getScore() {
        return score;
    }

    public GameState getGameState() {
        return gameState;
    }
}