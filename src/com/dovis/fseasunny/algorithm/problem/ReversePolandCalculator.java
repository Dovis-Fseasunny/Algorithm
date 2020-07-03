package com.dovis.fseasunny.algorithm.problem;

import com.dovis.fseasunny.algorithm.util.CalculatorUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * classname: ReversePolandCalculator
 * description: 逆波兰计算器
 * date: 2020/7/2 11:38
 * author: xue
 * version: 1.0
 */
public class ReversePolandCalculator {

    public static void main(String[] args) {
        String infix = "30*(2+3)*(5-2)";
//        String infix = "2*(3+5)";
        String[] suffix = conversionInfix2Suffix(infix);
        System.out.println(Arrays.toString(suffix));
        int res = calculator(suffix);
        System.out.println(res);
    }

    /**
     * 计算后缀表达式的值
     */
    public static int calculator(String[] suffixExpression) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (String item : suffixExpression) {
            if (Character.isDigit(item.codePointAt(0))) {
                stack.push(Integer.parseInt(item));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                res = CalculatorUtils.cal(num1, num2, item.codePointAt(0));
                stack.push(res);
            }
        }
        return res;
    }

    /**
     * Converts an infix expression to a postfix expression
     */
    public static String[] conversionInfix2Suffix(String infix) {
        Stack<String> intermediateStack = new Stack<>();
        List<String> resultList = new ArrayList<>();

        char[] chars = infix.toCharArray();

        /*
         * Traverse the infix expression from left to right
         * */
        for (int i = 0; i < chars.length; i++) {
            /*
             * if it is a number, consider multiple digit
             * */
            if (Character.isDigit(chars[i])) {
                StringBuilder sb = new StringBuilder();
                sb.append(chars[i]);
                while (Character.isDigit(chars[++i])) {
                    sb.append(chars[i]);
                }
                --i;
                resultList.add(sb.toString());
                /*
                 *if it is a left parenthesis, push middle stack
                 */
            } else if (chars[i] == CalculatorUtils.LEFT) {
                intermediateStack.push(String.valueOf(chars[i]));
                /*
                 * if it's a close bracket, pop the top of the middle stack element until you encounter an open bracket,
                 * press into the resulting list, and pop the open bracket at the end
                 * */
            } else if (chars[i] == CalculatorUtils.RIGHT) {
                while ((intermediateStack.peek().charAt(0)) != (CalculatorUtils.LEFT)) {
                    resultList.add(intermediateStack.pop());
                }
                intermediateStack.pop();
                /*
                 *if it's an operator
                 */
            } else if (CalculatorUtils.isOperator(chars[i])) {
                while (true) {
                    if (intermediateStack.isEmpty() || (intermediateStack.peek().charAt(0)) != (CalculatorUtils.LEFT) ||
                            CalculatorUtils.priority(chars[i]) > CalculatorUtils.priority(intermediateStack.peek()
                                    .charAt(0))) {
                        intermediateStack.push(String.valueOf(chars[i]));
                        break;
                    } else if (CalculatorUtils.priority(chars[i]) <= CalculatorUtils.priority(intermediateStack.peek()
                            .charAt(0))) {
                        resultList.add(intermediateStack.pop());
                    }
                }
            }
        }
        while (!intermediateStack.isEmpty()) {
            resultList.add(intermediateStack.pop());
        }
        return resultList.toArray(new String[0]);
    }
}
