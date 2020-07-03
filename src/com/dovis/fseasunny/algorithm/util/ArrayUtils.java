package com.dovis.fseasunny.algorithm.util;

/**
 * classname: ArrayUtils
 * description:
 * date: 2020/6/22 15:55
 * author: xue
 * version: 1.0
 */
public class ArrayUtils {

    /**
     * 打印二维数组
     */
    public static String displayArray(int[][] root) {
        StringBuilder sb = new StringBuilder();
        for (int[] arr : root) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
                if (i != arr.length - 1) {
                    sb.append("\0").append("\0");
                }
            }
            sb.append("\r\n");
        }
        return sb.toString();
    }
}
