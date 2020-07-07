package com.dovis.fseasunny.algorithm.sort;

import java.util.Arrays;

/**
 * classname: InsertSorted
 * description:
 * date: 2020/7/6 16:31
 * author: xue
 * version: 1.0
 */
public class InsertSorted {

    public static void main(String[] args) {
        Integer[] a = new Integer[]{8, 7, 6, 5};
        insertSorted(a);
        insertionSort(a);
        System.out.println(Arrays.toString(a));

    }

    public static void insertSorted(Integer[] disorderly) {
        for (int i = 1; i < disorderly.length; i++) {
            int insertVal = disorderly[i];
            int insertIndex = i - 1;

            while (insertIndex >= 0 && insertVal < disorderly[insertIndex]) {
                disorderly[insertIndex + 1] = disorderly[insertIndex];
                insertIndex--;
            }
            disorderly[insertIndex + 1] = insertVal;
        }
    }

    public static <AnyType extends Comparable<AnyType>> void insertionSort(AnyType[] a) {
        int j;
        for (int p = 1; p < a.length; p++) {
            AnyType tmp = a[p];
            for (j = p; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--)
                a[j] = a[j - 1];
            a[j] = tmp;
        }
    }
}
