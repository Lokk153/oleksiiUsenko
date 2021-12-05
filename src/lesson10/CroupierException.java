package lesson10;

public class CroupierException extends Exception {

    public static void exception(String message) {
        switch (message) {
            case "not_enough_cards":
                System.out.println("Недостаточно карт!");
                break;
            case "deck_not_created":
                System.out.println("Колода не была создана!");
                break;
            case "too_many_players":
                System.out.println("Слишком много игроков!");
                break;
        }
    }
}

