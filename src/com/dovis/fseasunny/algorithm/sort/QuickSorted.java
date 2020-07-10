package com.dovis.fseasunny.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * classname: QuickSorted
 * description:
 * date: 2020/7/7 17:08
 * author: xue
 * version: 1.0
 */
public class QuickSorted {

    public static void main(String[] args) {

        Integer[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        List<Integer> arrList = Arrays.asList(arr);
        List<Integer> list = new ArrayList<>(arrList);
        quickSort(list);
        for (Integer i : list) {
            System.out.print(i + "\t");
        }
    }

    public static void quickSort(List<Integer> items) {
        if (items.size() > 1) {

            Integer chooseItem = items.get(items.size() / 2);

            List<Integer> small = new ArrayList<>();
            List<Integer> same = new ArrayList<>();
            List<Integer> large = new ArrayList<>();

            for (Integer item : items) {
                if (item < chooseItem) {
                    small.add(item);
                } else if (item > chooseItem) {
                    large.add(item);
                } else {
                    same.add(item);
                }
            }

            quickSort(small);
            quickSort(large);

            items.clear();
            items.addAll(small);
            items.addAll(same);
            items.addAll(large);
        }
    }
}
