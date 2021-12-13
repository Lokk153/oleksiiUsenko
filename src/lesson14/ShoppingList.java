package lesson14;

import java.util.*;

public class ShoppingList {
    public static void main(String[] args) {

        ArrayList<String> productName = new ArrayList<>();
        productName.add("Молоко");
        productName.add("Хлеб");
        productName.add("Яйца");
        productName.add("Мясо");
        productName.add("Яблоко");
        productName.add("Сыр");
        productName.add("Сахар");
        productName.add("Рыба");

        Map<String, Integer> shoppingList = new HashMap<>();

        //Заполнение списка продуктов случайными значениями
        for (int i = 0; i < 100; i++) {
            updateListValue(shoppingList, RandomCreator.getRandomListValue(productName), RandomCreator.getRandomIntValue(5));
        }
        Integer productAmount = 0;
        for (Integer value : shoppingList.values()) {
            productAmount += value;
        }
        System.out.println("Количество каждого товара: " + shoppingList);
        System.out.println("Количество товаров всего: " + productAmount);
    }

    public static void updateListValue(Map<String, Integer> map, String key, Integer value) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + value);
        } else {
            map.put(key, value);
        }
    }
}



