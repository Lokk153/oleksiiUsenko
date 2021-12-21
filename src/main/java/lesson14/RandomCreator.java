package lesson14;

import java.util.ArrayList;
import java.util.Random;

public class RandomCreator {
    public static ArrayList<Integer> createRandomArrayList(int minValue, int maxValue, int range) {

        ArrayList<Integer> randomArrayList = new ArrayList<>();

        for (int i = 0; i < range; i++) {
            int randomValue = getRandomIntValue(minValue, maxValue);
            randomArrayList.add(randomValue);
        }
        return randomArrayList;
    }

    public static int getRandomIntValue(int minValue, int maxValue) {
        Random randomInt = new Random();
        return minValue + randomInt.nextInt((maxValue - minValue) + 1);
    }

    public static int getRandomIntValue(int maxAmount) {
        int minAmount = 1;
        Random randomInt = new Random();
        return minAmount + randomInt.nextInt((maxAmount - minAmount) + 1);
    }

    public static String getRandomListValue(ArrayList<String> productName) {
        int randomArrayValue = new Random().nextInt(productName.size());
        return productName.get(randomArrayValue);
    }
}
