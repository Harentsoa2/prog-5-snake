package com.hei.school;


import com.hei.school.model.Game;

public class Main {

    public static void main(String[] args) {
        displayWelcomeMessage();

        Game game = new Game();
        game.start();
    }

    private static void displayWelcomeMessage() {
        System.out.println("=================================");
        System.out.println("      JEU DU SERPENT (SNAKE)");
        System.out.println("=================================");
        System.out.println("Contrôles:");
        System.out.println("  W ou w = Haut");
        System.out.println("  S ou s = Bas");
        System.out.println("  A ou a = Gauche");
        System.out.println("  D ou d = Droite");
        System.out.println("=================================");
        System.out.println("Tapez les lettres directement");
        System.out.println("(pas besoin d'appuyer sur ENTRÉE)");
        System.out.println("=================================");
        System.out.println("Le jeu commence dans 3 secondes...\n");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}