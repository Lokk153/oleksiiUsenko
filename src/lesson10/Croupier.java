package lesson10;

public class Croupier {
    public static void main(String[] args) {
        int players = 11;
        final int cardsPerPlayer = 5;
        Croupier.cardDistribution(players, cardsPerPlayer, DeckCreator.shuffle(DeckCreator.create()));
    }

    //Раздача карт
    public static void cardDistribution(int players, int cardsPerPlayer, String[] deck) {
        try {
            //Исключение в случае слишком большого кол-во игроков
            if (players > 10) {
                throw new CroupierException();
            }
            int playerNumber = 1;
            for (int j = 0; j < players * cardsPerPlayer; j++) {
                System.out.println("Игрок " + playerNumber + " получает карту - " + deck[j]);
                if (j % cardsPerPlayer == cardsPerPlayer - 1) {
                    System.out.println();
                    playerNumber++;
                }
            }
        } catch (CroupierException e) {
            CroupierException.exception("too_many_players");
        }
    }
}





