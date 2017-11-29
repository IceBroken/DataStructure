package com.datastructure.sort;

import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        Random rd = new Random(20);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * rd.nextInt(20);
            System.out.print(array[i] + "\t");
        }
        System.out.println();
        bubbleSort(array);
        for (int i : array) {
            System.out.print(i + "\t");
        }
    }

    /**
     * 冒泡排序 ASC
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
