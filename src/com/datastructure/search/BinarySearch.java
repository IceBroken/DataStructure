package com.datastructure.search;

public class BinarySearch {
    /**
     * 有序数组的二分查找
     * 递归查找
     */
    public static int binarySearch(int[] array, int low, int high, int key) {
        int middle = (low + high) / 2;
        if (array[middle] == key) {
            return middle;
        }
        if (low >= high) {
            return -1;
        } else if (key > array[middle]) {
            return binarySearch(array, middle + 1, high, key);
        } else if (key < array[middle]) {
            return binarySearch(array, low, middle - 1, key);
        }
        return -1;
    }

    /**
     * 有序数组的二分查找
     * 非递归查找
     */
    public static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (array[middle] == key) {
                return middle;
            } else if (key > array[middle]) {
                low = middle + 1;
            } else if (key < array[middle]) {
                high = middle - 1;
            }
        }
        return -1;
    }
}
