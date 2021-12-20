package lesson14;

import java.util.ArrayList;

public class HeapSorter {
    public static void main(String[] args) {

        ArrayList<Integer> list = RandomCreator.createRandomArrayList(0, 500, 100);
        System.out.println(list);
        System.out.println();

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for (Integer i : list) {
            if (i % 2 == 0 && i % 3 == 0) {
                list1.add(i);
                list2.add(i);
            } else if (i % 2 == 0) {
                list1.add(i);
            } else if (i % 3 == 0) {
                list2.add(i);
            } else {
                list3.add(i);
            }
        }

        System.out.println("Числа которые делятся на 2");
        printList(list1);
        System.out.println("Числа которые делятся на 3");
        printList(list2);
        System.out.println("Остальные числа");
        printList(list3);
    }

    public static void printList(ArrayList<Integer> list){
            System.out.println(list);
            System.out.println();
    }
}


