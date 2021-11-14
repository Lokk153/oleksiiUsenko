package lesson4;

import java.util.Arrays;
import java.util.Random;

public class evenNumberToZeroConverter {
    public static void main(String args[]) {

        //Инициализируем размер и кол-во элементов массива
        int arraySize = 20;
        int randomElementsInArray = 20;

        //Заполняем массив случайными значениями
        int[] randomValueArray = new int[arraySize];
        for (int i = 0; i < randomElementsInArray; ++i) {
            randomValueArray[i] = getSomeValue();
        }
        System.out.println("Array = " + Arrays.toString(randomValueArray));

        //Проверяем каждый элемент массива на четность
        for (int i = 0; i < randomValueArray.length; i++) {
            if (randomValueArray[i] % 2 == 0) {
                randomValueArray[i] = 0;
            }
        }
        System.out.println("Array with odd numbers = " + Arrays.toString(randomValueArray));
    }

    //Генерируем случайные числа
    public static int getSomeValue() {
        Random random = new Random();
        return random.nextInt(100);
    }
}

