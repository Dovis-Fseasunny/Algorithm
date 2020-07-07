package com.dovis.fseasunny.algorithm.sort;

import java.util.Arrays;

/**
 * classname: BubbleSorted
 * description:
 * date: 2020/7/6 14:06
 * author: xue
 * version: 1.0
 */
public class BubbleSorted {

    public static void main(String[] args) {
        int[] a = new int[]{8, 7, 6, 5};
        bubbleSorted(a);
//        System.out.println(Arrays.toString(a));

    }

    public static void bubbleSorted(int[] disorderly) {
        int temp;
        boolean isSorted = false;
        for (int i = 0; i < disorderly.length - 1; i++) {
            for (int j = 0; j < disorderly.length - 1 - i; j++) {
                if (disorderly[j] > disorderly[j + 1]) {
                    isSorted = true;
                    temp = disorderly[j];
                    disorderly[j] = disorderly[j + 1];
                    disorderly[j + 1] = temp;
                }
            }
            if (!isSorted) break;
            else isSorted = false;
            System.out.printf("第%d次排序后：" + Arrays.toString(disorderly) + "\n", i + 1);
        }
    }
}
