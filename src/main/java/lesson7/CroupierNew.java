package lesson7;

public class CroupierNew {
    public static void main(String[] args) {
        int players = 4;
        int cardsPerPlayer = 5;

        Deck myDeck = new Deck();
        myDeck.create();
        myDeck.shuffle();
        myDeck.cardDistribution(players, cardsPerPlayer);
    }


    public static class Deck {

        final String[] suits = {
                "Spades", "Hearts", "Diamonds", "Clubs"
        };
        final String[] ranks = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"
        };

        String[] deck = new String[suits.length * ranks.length];

        //Инициализация колоды
        public void create() {
            //for (int i = 0; i < deck.length; i++) deck[i] = i;
            for (int i = 0; i < ranks.length; i++) {
                for (int j = 0; j < suits.length; j++) {
                    deck[suits.length * i + j] = ranks[i] + " " + suits[j];
                }
            }
        }

        //Смешиваем колоду
        public void shuffle() {
            for (int i = 0; i < deck.length; i++) {
                int randomCard = i + (int) (Math.random() * (deck.length - i)); //Случайная карта в колоде
                String temp = deck[randomCard];
                deck[randomCard] = deck[i];
                deck[i] = temp;
            }
        }

        //Вывод карт на экран
        public void cardDistribution(int players, int cardsPerPlayer) {
            int playerNumber = 1;
            for (int j = 0; j < players * cardsPerPlayer; j++) {
                System.out.println("Игрок " + playerNumber + " получает карту - " + deck[j]);
                if (j % cardsPerPlayer == cardsPerPlayer - 1) {
                    System.out.println();
                    playerNumber++;
                }
            }
        }
    }
}


