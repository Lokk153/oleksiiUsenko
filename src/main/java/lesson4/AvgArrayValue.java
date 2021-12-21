package lesson4;

import java.util.Arrays;
import java.util.Random;

public class AvgArrayValue {
    public static void main(String args[]) {

        //Инициализируем размер и кол-во элементов массива
        int arraySize = 5;
        int randomElementsInArray = 5;

        //Заполняем массив случайными значениями
        int[] randomValueArray = new int[arraySize];
        for (int i = 0; i < randomElementsInArray; ++i) {
            randomValueArray[i] = getSomeValue();
        }
        System.out.println("Array = " + Arrays.toString(randomValueArray));

        //Суммируем значения элементов массива
        double result = 0;
        for (int i = 0; i < randomElementsInArray; i++)
            result = result + randomValueArray[i];
        System.out.println("Среднее значение равно " + result / arraySize);
    }

    //Генерируем случайные числа
    public static int getSomeValue() {
        Random random = new Random();
        return random.nextInt(100);
    }
}
