package lesson10;

class DeckCreator extends Deck {

    //Создание колоды
    public static String[] create() {
        try {
            //Исключение в случае меньшего кол-ва карт чем нужно
            if (suits.length < 4 | ranks.length < 13) {
                throw new CroupierException.NotEnoughCardsException();
            }
            for (int i = 0; i < ranks.length; i++) {
                for (int j = 0; j < suits.length; j++) {
                    deck[suits.length * i + j] = ranks[i] + " " + suits[j];
                }
            }
            return deck;
        } catch (CroupierException.NotEnoughCardsException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Перетасовка колоды
    public static String[] shuffle(String[] deck) {
        try {
            //Исключение в случае несоздания колоды
            if (deck == null) {
                throw new CroupierException.DeckNotCreated();
            }
            for (int i = 0; i < deck.length; i++) {
                int randomCard = i + (int) (Math.random() * (deck.length - i));
                String temp = deck[randomCard];
                deck[randomCard] = deck[i];
                deck[i] = temp;
            }
            return deck;
        } catch (CroupierException.DeckNotCreated e) {
            e.printStackTrace();
            return null;
        }
    }
}
