package com.dovis.fseasunny.algorithm.sort;

import java.util.Arrays;

/**
 * classname: SelectSorted
 * description:
 * date: 2020/7/6 14:51
 * author: xue
 * version: 1.0
 */
public class SelectSorted {

    public static void main(String[] args) {
        int[] a = new int[]{8, 7, 6, 5};
        selectSorted(a);

    }

    public static void selectSorted(int[] disorderly) {
        int minIndex = 0;
        int temp;
        for (int j = 0; j < disorderly.length - 1; j++) {
            for (int i = j + 1; i < disorderly.length; i++) {
                if (disorderly[minIndex] > disorderly[i]) {
                    minIndex = i;
                }
            }
            if (minIndex != j) {
                temp = disorderly[j];
                disorderly[j] = disorderly[minIndex];
                disorderly[minIndex] = temp;
                System.out.printf("第%d次排序后：" + Arrays.toString(disorderly) + "\n", j + 1);
            }
        }
    }

}
