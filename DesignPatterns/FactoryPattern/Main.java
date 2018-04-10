package DesignPatterns.FactoryPattern;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create the factory object
        EnemyShipFactory shipFactory = new EnemyShipFactory();

        // Enemy ship object
        EnemyShip theEnemy = null;

        Scanner userInput = new Scanner(System.in);

        System.out.println("What type of ship? (U / R / B)");

        if (userInput.hasNextLine()) {
            String typeOfShip = userInput.nextLine();

            theEnemy = shipFactory.makeEnemyShip(typeOfShip);
        }

        if (theEnemy != null) {
            doStuffEnemy(theEnemy);
        } else {
            System.out.println("Enter a U, R or B next time.");
        }
    }

    // Executes methods of the super class
    public static void doStuffEnemy(EnemyShip anEnemyShip){

        anEnemyShip.displayEnemyShip();

        anEnemyShip.followHeroShip();

        anEnemyShip.enemyShipShoots();

    }
}
