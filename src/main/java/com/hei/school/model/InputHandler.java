package com.hei.school.model;

import java.io.IOException;


import java.io.IOException;import java.util.Scanner;



public class InputHandler {
    private Direction pendingDirection = null;
    private final Object lock = new Object();
    private volatile boolean running = true;
    private Thread inputThread;

    public InputHandler() {
        startInputThread();
    }


    private void startInputThread() {
        inputThread = new Thread(() -> {
            try {
                while (running) {
                    if (System.in.available() > 0) {
                        int key = System.in.read();
                        char c = Character.toLowerCase((char) key);

                        Direction newDirection = Direction.fromKey(c);
                        if (newDirection != null) {
                            synchronized (lock) {
                                pendingDirection = newDirection;
                            }
                        }
                    }
                    Thread.sleep(10);
                }
            } catch (IOException | InterruptedException _) {

            }
        });
        inputThread.setDaemon(true);
        inputThread.start();
    }


    public Direction readInput() {
        synchronized (lock) {
            Direction result = pendingDirection;
            pendingDirection = null;
            return result;
        }
    }


    public void stop() {
        running = false;
        if (inputThread != null) {
            inputThread.interrupt();
        }
    }
}
