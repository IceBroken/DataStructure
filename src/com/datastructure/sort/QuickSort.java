package com.datastructure.sort;

public class QuickSort {
    /**
     * 快速排序 ASC
     */
    public static void quickSort(int[] array, int l, int r) {
        if (l < r) {
            int i = l, j = r, x = array[l];
            while (i < j) {
                while (i < j && array[j] > x)
                    j--;
                if (i < j)
                    array[i++] = array[j];
                while (i < j && array[i] < x)
                    i++;
                if (i < j)
                    array[j--] = array[i];
            }
            array[i] = x;
            quickSort(array, l, i - 1);
            quickSort(array, i + 1, r);
        }
    }
}
