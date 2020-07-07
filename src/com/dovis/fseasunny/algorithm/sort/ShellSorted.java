package com.dovis.fseasunny.algorithm.sort;

import java.util.Arrays;

/**
 * classname: ShellSorted
 * description: 希尔(缩小增量)排序
 * date: 2020/7/6 17:20
 * author: xue
 * version: 1.0
 */
public class ShellSorted {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        bubbleShellSorted(arr);
        insertShellSorted(arr);
        System.out.println(Arrays.toString(arr));

    }


    public static void insertShellSorted(int[] disorderly) {
        for (int step = disorderly.length / 2; step > 0; step /= 2) {
            for (int i = step; i < disorderly.length; i++) {
                int insertIndex = i;  //2
                int insertVal = disorderly[insertIndex];  //1
                if (disorderly[insertIndex] < disorderly[insertIndex - step]) {
                    while (insertIndex - step >= 0 && insertVal < disorderly[insertIndex - step]) {
                        disorderly[insertIndex] = disorderly[insertIndex - step];
                        insertIndex -= step;
                    }
                    disorderly[insertIndex] = insertVal;
                }
            }
            System.out.println(Arrays.toString(disorderly));
        }
    }


    public static void bubbleShellSorted(int[] disorderly) {
        int temp;
        for (int step = disorderly.length / 2; step > 0; step /= 2) {
            for (int k = step; k < disorderly.length; k++) {
                for (int j = k - step; j >= 0; j -= step) {
                    if (disorderly[j] > disorderly[j + step]) {
                        temp = disorderly[j];
                        disorderly[j] = disorderly[j + step];
                        disorderly[j + step] = temp;
                    }
                }
            }
        }

      /* for (int j = 5; j < disorderly.length; j++) {
            for (int i = j - 5; i >= 0; i -= 5) {
                if (disorderly[i] > disorderly[i + 5]) {
                    temp = disorderly[i];
                    disorderly[i] = disorderly[i + 5];
                    disorderly[i + 5] = temp;
                }
            }
        }
        for (int j = 2; j < disorderly.length; j++) {
            for (int i = j - 2; i >= 0; i -= 2) {
                if (disorderly[i] > disorderly[i + 2]) {
                    temp = disorderly[i];
                    disorderly[i] = disorderly[i + 2];
                    disorderly[i + 2] = temp;
                }
            }
        }
        for (int j = 1; j < disorderly.length; j++) {
            for (int i = j - 1; i >= 0; i -= 1) {
                if (disorderly[i] > disorderly[i + 1]) {
                    temp = disorderly[i];
                    disorderly[i] = disorderly[i + 1];
                    disorderly[i + 1] = temp;
                }
            }
        }*/


    }
}
