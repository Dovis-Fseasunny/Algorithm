package com.dovis.fseasunny.algorithm.problem;

import com.dovis.fseasunny.algorithm.datastructure.stack.ArrayStack;
import com.dovis.fseasunny.algorithm.util.CalculatorUtils;

/**
 * classname: InfixCalculator
 * description: 中缀计算器
 * date: 2020/7/2 15:27
 * author: xue
 * version: 1.0
 */
public class InfixCalculator {

    public static void main(String[] args) {
        int calculator = calculator("3+6*6-2");

        System.out.println(calculator);
    }

    public static int calculator(String eval) {
        ArrayStack numStack = new ArrayStack();
        ArrayStack operatorStack = new ArrayStack();

        for (char c : eval.toCharArray()) {
            if (!CalculatorUtils.isOperator(c)) {
                numStack.push(c - 48);
            } else {
                if (!operatorStack.isEmpty()) {
                    if (CalculatorUtils.priority(c) < CalculatorUtils.priority(operatorStack.peek())) {
                        //从数字栈pop两个，操作符栈pop一个运算，再把当前运算符号压栈
                        popStack2calculator(numStack, operatorStack);
                    }
                }
                operatorStack.push(c);
            }
        }
        while (numStack.size() != 1) {
            popStack2calculator(numStack, operatorStack);
        }
        return numStack.pop();
    }

    private static void popStack2calculator(ArrayStack numStack, ArrayStack operatorStack) {
        int firstNum;
        int secondNum;
        int res;
        int operator;
        secondNum = numStack.pop();
        firstNum = numStack.pop();
        operator = operatorStack.pop();
        res = CalculatorUtils.cal(firstNum, secondNum, operator);
        numStack.push(res);
    }


}
