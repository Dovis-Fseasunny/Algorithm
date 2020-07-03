package com.dovis.fseasunny.algorithm.util;

/**
 * classname: CalculatorUtils
 * description:
 * date: 2020/7/2 15:37
 * author: xue
 * version: 1.0
 */
public class CalculatorUtils {

    public static final char LEFT = '(';
    public static final char RIGHT = ')';
    public static final char ADD = '+';
    public static final char SUB = '-';
    public static final char MUL = '*';
    public static final char DIV = '/';

    public static int cal(int firstNum, int secondNum, int operator) {
        int res = 0;
        switch (operator) {
            case ADD:
                res = firstNum + secondNum;
                break;
            case SUB:
                res = firstNum - secondNum;
                break;
            case MUL:
                res = firstNum * secondNum;
                break;
            case DIV:
                res = firstNum / secondNum;
                break;
        }
        return res;
    }

    public static int priority(int operator) {
        if (operator == MUL || operator == DIV)
            return 1;
        else if (operator == ADD || operator == SUB)
            return 0;
        else return -1;
    }

    public static boolean isOperator(int operator) {
        return operator == ADD || operator == SUB || operator == MUL || operator == DIV;
    }
}
