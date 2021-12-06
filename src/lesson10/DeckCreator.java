package lesson10;

class DeckCreator extends Deck {

    //Создание колоды
    public static String[] create() {
        try {
            //Исключение в случае меньшего кол-ва карт чем нужно
            if (suits.length < 4 | ranks.length < 13) {
                throw new CroupierException();
            }
            for (int i = 0; i < ranks.length; i++) {
                for (int j = 0; j < suits.length; j++) {
                    deck[suits.length * i + j] = ranks[i] + " " + suits[j];
                }
            }
        } catch (CroupierException e) {
            CroupierException.exception("not_enough_cards");
            return null;
        }
        return deck;
    }

    //Перетасовка колоды
    public static String[] shuffle(String[] deck) {
        try {
            //Исключение в случае несоздания колоды
            if (deck == null) {
                throw new CroupierException();
            }
            for (int i = 0; i < deck.length; i++) {
                int randomCard = i + (int) (Math.random() * (deck.length - i));
                String temp = deck[randomCard];
                deck[randomCard] = deck[i];
                deck[i] = temp;
            }
        } catch (CroupierException e) {
            CroupierException.exception("deck_not_created");
            return null;
        }
        return deck;
    }
}
