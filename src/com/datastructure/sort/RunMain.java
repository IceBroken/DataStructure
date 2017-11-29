package com.datastructure.sort;

import java.util.Random;

public class RunMain {
    public static void main(String[] args) {
        Random rd = new Random(20);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * rd.nextInt(20);
            System.out.print(array[i] + "\t");
        }
        System.out.println();
        Long startTime = System.currentTimeMillis();
//        BubbleSort.bubbleSort(array);//冒泡排序 ASC
        QuickSort.quickSort(array, 0, array.length - 1);//快速排序 ASC
        Long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) / 1000);
        for (int i : array) {
            System.out.print(i + "\t");
        }
    }
}
