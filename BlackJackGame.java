package edu.hpu.mbecker4.csci2911.cardgame;

import java.util.Random;
import java.util.Scanner;

public class BlackJackGame {

    Card[] d;
    Random bag = new Random();

    public BlackJackGame() {
        d = new Card[52]; // make the array of [this many] blank Cards
        for (int n = 0; n < 52; n++) {
            d[n] = new Card(n);
        }
    }

    public Card pickACard() {
        int num = bag.nextInt(52);
        return d[num];
    }

    public void shuffle() {
        for (int k = 0; k < 1000; k++) {
            int i = bag.nextInt(52);
            int j = bag.nextInt(52);
            Card t = d[i];
            d[i] = d[j];
            d[j] = t;
        }
    }
    int cardNum = 0; // number of next card to be dealt    

    public Card dealACard() {
        if (cardNum >= 52) { // if end of deck is reached
            shuffle();
            cardNum = 0;
        }
        cardNum++; // set up next card before return forces exit
        return d[cardNum - 1];
    }

    public static double playOneHand() {
        BlackJackGame theDeck = new BlackJackGame();
        theDeck.shuffle();

        int dealerTotal = 0;
        int yourTotal = 0;
        Card dealerCard = theDeck.dealACard();
        Card yourCard = theDeck.dealACard();
        System.out.println("Dealer: " + dealerCard);
        System.out.println("You: " + yourCard);
        dealerTotal = dealerTotal + dealerCard.value;
        yourTotal = yourTotal + yourCard.value;
        dealerCard = theDeck.dealACard();
        yourCard = theDeck.dealACard();
        System.out.println("Dealer card in the hole.");
        System.out.println("You: " + yourCard);
        dealerTotal = dealerTotal + dealerCard.value;
        yourTotal = yourTotal + yourCard.value;

        if (yourTotal == 21) {
            System.out.println("Dealer shows hole card: The " + dealerCard);
            if (dealerTotal == 21) {
                System.out.println("It's a tie.");
                return 0;
            } else {
                System.out.println("You win.");
                return 1.5;
            }
        } else {
            String hitOrStand;
            do {
                
                Scanner keyboard = new Scanner(System.in);
                do {
                    System.out.println("you have " + yourTotal);
                    System.out.println("Hit or Stand?");
                    hitOrStand = keyboard.nextLine();
                } while (!hitOrStand.equalsIgnoreCase("hit") && !hitOrStand.equalsIgnoreCase("h") &&
                        !hitOrStand.equalsIgnoreCase("s") && !hitOrStand.equalsIgnoreCase("stand"));

                if (hitOrStand.equalsIgnoreCase("hit") || hitOrStand.equalsIgnoreCase("h")) {
                    yourCard = theDeck.dealACard();
                    yourTotal = yourTotal + yourCard.value;
                } else if (hitOrStand.equalsIgnoreCase("stand") || hitOrStand.equalsIgnoreCase("s")) {
                    System.out.println("Dealer shows hole card: The " + dealerCard);

                    while (dealerTotal < 17) {
                        dealerCard = theDeck.dealACard();
                        dealerTotal = dealerTotal + dealerCard.value;
                        System.out.println("Dealer draws the " + dealerCard);
                    }
                    if (dealerTotal > 21) {
                            System.out.println("Dealer busts.");
                            return 1;
                    } else if (dealerTotal > yourTotal) {
                        System.out.println("Dealer has " + dealerTotal);
                        System.out.println("You have " + yourTotal);
                        System.out.println("Dealer wins.");
                        return -1;
                    } else if (dealerTotal < yourTotal) {
                        System.out.println("Dealer has " + dealerTotal);
                        System.out.println("You have " + yourTotal);
                        System.out.println("You win.");
                        return 1;
                    } else {
                        return 0;
                    }
                }
                
            } while (yourTotal < 21 && !hitOrStand.equalsIgnoreCase("stand"));
        }
        System.out.println(yourTotal + " You bust.");
        return -1;
    }
}
