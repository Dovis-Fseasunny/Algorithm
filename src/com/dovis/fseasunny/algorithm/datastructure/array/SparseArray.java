package com.dovis.fseasunny.algorithm.datastructure.array;

import static com.dovis.fseasunny.algorithm.util.ArrayUtils.displayArray;

/**
 * classname: SparseArray
 * description:
 * date: 2020/6/22 11:41
 * author: xue
 * version: 1.0
 */
public class SparseArray {

    /**
     * 转换二维数组为稀疏数组
     */
    public static int[][] conversion2SparseArray(int[][] source, int common) {
        int sum = 0, counter = 0;
        for (int[] ints : source) {
            for (int anInt : ints) {
                if (anInt != common) {
                    sum++;
                }
            }
        }
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = source.length;
        sparseArray[0][1] = source.length;
        sparseArray[0][2] = sum;
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length; j++) {
                if (source[i][j] != common) {
                    counter++;
                    sparseArray[counter][0] = i;
                    sparseArray[counter][1] = j;
                    sparseArray[counter][2] = source[i][j];
                }
            }
        }
        return sparseArray;
    }

    /**
     * 稀疏数组还原为二维数组
     */
    public static int[][] reduction2Array(int[][] sparse) {
        int[][] array = new int[sparse[0][0]][sparse[0][1]];
        for (int i = 1; i < sparse.length; i++) {
            array[sparse[i][0]][sparse[i][1]] = sparse[i][2];
        }
        return array;
    }



    public static void main(String[] args) {
        int[][] board = new int[11][11];
        board[1][2] = 1;
        board[2][4] = 2;
        board[5][6] = 2;
        board[5][7] = 3;

        System.out.println(displayArray(board));
        int[][] sparseArray = conversion2SparseArray(board, 0);
        System.out.println(displayArray(sparseArray));
        int[][] array = reduction2Array(sparseArray);
        System.out.println(displayArray(array));
    }
}
