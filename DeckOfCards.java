package edu.hpu.mbecker4.csci2911.cardgame;

import java.util.Random;

public class DeckOfCards {

    Card[] d;
    Random bag = new Random();

    public DeckOfCards() {
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

    public void print() {
        for (int i = 0; i < 52; i++) {
            System.out.println(d[i]);
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

}
