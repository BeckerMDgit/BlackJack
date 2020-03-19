/*
Author: Matthew Beckr
Class:  CSCI 2911 8A
Date:   10/03/2018
Goal:   Create a program to play cards with a user.
 */
package edu.hpu.mbecker4.csci2911.cardgame;

import java.util.Scanner;

public class CardGame {

    public static void main(String[] args) {
//        String playerAnswer;
//        do {
//            DeckOfCards theDeck = new DeckOfCards();
//            theDeck.shuffle();
//            int myScore = 0;
//            int yourScore = 0;
//            for (int i = 0; i < 30; i++) {
//                Card myCard = theDeck.dealACard();
//                Card yourCard = theDeck.dealACard();
//                System.out.println("I drew the " + myCard + ".");
//                System.out.println("You drew the " + yourCard + ".");
//                if (myCard.value > yourCard.value) {
//                    System.out.println("Ha! I won!");
//                    myScore = myScore + 1;
//                } else if (myCard.value < yourCard.value) {
//                    System.out.println("...Draw again.");
//                    yourScore = yourScore + 1;
//                } else if (myCard.value == yourCard.value) {
//                    System.out.println("It's a wash.");
//                } else {
//                    System.out.println("That's Game.");
//                }
//
//            }
//            System.out.println("My Score: " + myScore);
//            System.out.println("Your Score: " + yourScore);
//            if (myScore > yourScore) {
//                System.out.println("I win!");
//            } else if (myScore < yourScore) {
//                System.out.println("You win this time...");
//            } else {
//                System.out.println("It's a tie.");
//            }
//            System.out.println("Would you like to play again?");
//            System.out.println("Type \"Yes\" to play again.");
//            System.out.println("Type \"No\" to exit.");
//            Scanner keyboard = new Scanner(System.in);
//            playerAnswer = keyboard.nextLine();
//        } while (playerAnswer.equalsIgnoreCase("yes"));

        String playerAnswer;
        System.out.println("Welcome to the Black Jack table.");
        double playerWinnings;
        do {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Place your bet:");
            int playerBet = keyboard.nextInt();

            do {
                System.out.println("");
                System.out.println("");
                playerWinnings = playerBet * BlackJackGame.playOneHand();
                System.out.println("Would you like to play again?");
                System.out.println("Type \"Yes\" to play.");
                System.out.println("Type \"No\" to exit.");
                playerAnswer = keyboard.nextLine();

            } while (!playerAnswer.equalsIgnoreCase("yes") && (!playerAnswer.equalsIgnoreCase("no")));
            
            System.out.println(playerWinnings);
        } while (playerAnswer.equalsIgnoreCase("yes"));
    } // end of main
}
