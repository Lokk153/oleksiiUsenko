package lesson14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class DuplicateRemover {
    public static void main(String[] args) {
        long startTime;
        long stopTime;

        ArrayList<Integer> listWithDuplicate = new ArrayList<>(RandomCreator.createRandomArrayList(0, 20, 100));
        int listSize = listWithDuplicate.size();

        System.out.println("Список с дублями " + listWithDuplicate);
        System.out.println();

        //Убираем дубликаты сохраняя последовательность
        startTime = System.nanoTime();
        Set<Integer> listWithoutDuplicate = new LinkedHashSet<>(listWithDuplicate);
        ArrayList<Integer> list = new ArrayList<>(listWithoutDuplicate);
        stopTime = System.nanoTime();
        getExecutionTime(list, startTime, stopTime, listSize);

        //Убираем дубликаты не сохраняя последовательность
        startTime = System.nanoTime();
        Set<Integer> listWithoutDuplicate2 = new HashSet<>(listWithDuplicate);
        ArrayList<Integer> list2 = new ArrayList<>(listWithoutDuplicate2);
        stopTime = System.nanoTime();
        getExecutionTime(list2, startTime, stopTime, listSize);

        //Убираем дубликаты сохраняя последовательность через циклы
        startTime = System.nanoTime();
        removeDuplicates(listWithDuplicate);
        stopTime = System.nanoTime();
        getExecutionTime(listWithDuplicate, startTime, stopTime, listSize);
    }

    private static void removeDuplicates(ArrayList<Integer> list) {
        int size = list.size();

        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (!list.get(j).equals(list.get(i)))
                    continue;
                list.remove(j);
                j--;
                size--;
            }
        }
    }

    private static void getExecutionTime(ArrayList<Integer> list, long startTime, long stopTime, int listSize) {
        System.out.println("Список без дубликатов " + list);
        System.out.println("Время выполнения = " + (stopTime - startTime) / 1000f + "ms. " + "Количество удаленных дубликатов = " + (listSize - list.size()));
        System.out.println();
    }
}
