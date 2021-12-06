package lesson10;

public class Deck {

    final static String[] suits = {
            "Spades", "Hearts", "Diamonds", "Clubs"
    };
    final static String[] ranks = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"
    };
    final static String[] deck = new String[suits.length * ranks.length];

}