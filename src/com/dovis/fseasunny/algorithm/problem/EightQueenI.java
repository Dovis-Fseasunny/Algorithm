package com.dovis.fseasunny.algorithm.problem;

/**
 * classname: EightQueenI
 * description: 八皇后问题
 * date: 2020/7/6 10:51
 * author: xue
 * version: 1.0
 */
public class EightQueenI {

    int max = 8;
    int[] board = new int[max];
    int count = 0;

    public static void main(String[] args) {
        EightQueenI queenI = new EightQueenI();
        queenI.place(0);
    }


    public void place(int n) {
        //直到放置到n==8时，说明前8个皇后都没有冲突
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            //现在第n个位置放置皇后
            board[n] = i;
            //如果没有冲突
            if (judgeConflict(n)) {
                //在n+1个位置放置皇后
                place(n + 1);
            }
        }
    }


    public boolean judgeConflict(int n) {
        //需要和前面n-1个皇后判断位置是否冲突
        for (int i = 0; i < n; i++) {
            //不在同一列或者同一对角线(即斜率不为1)则不冲突
            if (board[i] == board[n] || Math.abs(n - i) == Math.abs(board[n] - board[i])) {
                return false;
            }
        }
        return true;
    }


    public void print() {
        count++;
        System.out.print(count + ":\t");
        for (int queenIndex : board) {
            System.out.print(queenIndex + "\t");
        }
        System.out.println();
    }
}
