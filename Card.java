package edu.hpu.mbecker4.csci2911.cardgame;

public class Card {

    //  instance variables:
    int value;
    String rank, suit, color;

    //  constructor
    public Card(int num) {

        //  fill in value
        value = num % 13 + 1;
        if (num % 13 == 0) {
            value = 11;   // Ace is a special case
        }
        if (num % 13 >= 10) {
            value = 10;
        }
        
        //  fill in suit
        switch (num / 13) {
            case 0:
                suit = "Spades";
                color = "Black";
                break;
            case 1:
                suit = "Hearts";
                color = "Red";
                break;
            case 2:
                suit = "Clubs";
                color = "Black";
                break;
            case 3:
                suit = "Diamonds";
                color = "Red";
                break;
        }

        // fill in the rank
        switch (num % 13) {
            case 0:
                rank = "Ace";
                break;
            case 1:
                rank = "Two";
                break;
            case 2:
                rank = "Three";
                break;
            case 3:
                rank = "Four";
                break;
            case 4:
                rank = "Five";
                break;
            case 5:
                rank = "Six";
                break;
            case 6:
                rank = "Seven";
                break;
            case 7:
                rank = "Eight";
                break;
            case 8:
                rank = "Nine";
                break;
            case 9:
                rank = "Ten";
                break;
            case 10:
                rank = "Jack";
                break;
            case 11:
                rank = "Queen";
                break;
            case 12:
                rank = "King";
                break;
        }
    } // end of constructor

    public String toString() {
        return (rank + " of " + suit);
    }
}
