package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = new int[100000];
        Random random = new Random();

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = random.nextInt();
        }

        int[] arr2 = new int[100000];
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = random.nextInt();
        }

        int[] arr3 = new int[100000];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = random.nextInt();
        }

        long start = System.currentTimeMillis();
        // IntegerListImpl.sortBubble(arr1); // 14211 мс
        // IntegerListImpl.sortSelection(arr2); // 4242 мс
         // IntegerListImpl.sortInsertion(arr3); // 759 мс
        System.out.println(System.currentTimeMillis() - start);


    }
}