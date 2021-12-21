package lesson10;

public class CroupierException extends Exception {

    public static class TooManyPlayersException extends CroupierException {
        public TooManyPlayersException() {
        }

        @Override
        public void printStackTrace() {
            System.out.println("Слишком много игроков!");
            super.printStackTrace();
        }

    }

    public static class NotEnoughCardsException extends CroupierException {
        public NotEnoughCardsException() {
        }

        @Override
        public void printStackTrace() {
            System.out.println("Недостаточно карт!");
            super.printStackTrace();
        }
    }

    public static class DeckNotCreated extends CroupierException {
        public DeckNotCreated() {
        }

        @Override
        public void printStackTrace() {
            System.out.println("Колода не была создана!");
            super.printStackTrace();

        }
    }
    public static class NoDeckToDeal extends CroupierException {
        public NoDeckToDeal() {
        }

        @Override
        public void printStackTrace() {
            System.out.println("Нет карт для игры!");
            super.printStackTrace();

        }
    }


}
