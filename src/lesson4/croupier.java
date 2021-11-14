package lesson4;

public class croupier {
    public static void main(String[] args) {

        //Инициализируем кол-во игроков и карт на игрока
        int players = 4;
        int cardsPerPlayer = 5;

        String[] suits = {
                "Spades", "Hearts", "Diamonds", "Clubs"
        };
        String[] ranks = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"
        };

        //Количество карт всего
        int cardsAmount = suits.length * ranks.length;

        //Инициализация колоды
        String[] deck = new String[cardsAmount];
        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                deck[suits.length * i + j] = ranks[i] + " " + suits[j];
            }
        }

        //Смешиваем колоду
        for (int i = 0; i < cardsAmount; i++) {
            int randomCard = i + (int) (Math.random() * (cardsAmount - i)); //Случайная карта в колоде
            String temp = deck[randomCard];
            deck[randomCard] = deck[i];
            deck[i] = temp;
        }

        //Вывод карт на экран
        int i = 1;
        for (int j = 0; j < players * cardsPerPlayer; j++) {
            System.out.println("Игрок " + i + " получает карту - " + deck[j]);
            if (j % cardsPerPlayer == cardsPerPlayer - 1){
                System.out.println();
                i++;
            }
        }
    }

}

