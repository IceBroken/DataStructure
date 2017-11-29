package com.datastructure.search;

public class RunMain {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        Long startTime = System.currentTimeMillis();
//        int index = BinarySearch.binarySearch(array, 0, array.length - 1, 11);
        int index = BinarySearch.binarySearch(array, 6);
        Long endTime = System.currentTimeMillis();
        System.out.println((startTime - endTime) / 1000);
        if (index == -1) {
            System.out.println("Can't find the index");
        } else {
            System.out.println(array[index]);
        }
    }
}
