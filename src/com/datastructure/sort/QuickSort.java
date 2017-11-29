package com.datastructure.sort;

public class QuickSort {
    public static void main(String[] args) {

    }

    /**
     * 快速排序 ASC
     */
    public static void quickSort(int[] array, int l, int r) {
        if (l < r) {
            int i = l, j = r, x = array[l];
            while (i < j && array[j] > x)
                j--;
            if (i < j)
                array[j--] = x;
            while (i < j && array[i] < x)
                i++;
            if (i < j)
                array[i++] = x;
        }
    }
}
