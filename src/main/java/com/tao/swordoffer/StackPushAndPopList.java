package com.tao.swordoffer;

import java.util.Stack;

/**
 * @author: Penger
 * @time: 2019/3/24
 * @description: <p>输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * </p>
 * @solution: 将压入栈的队列依次入栈，每个入栈时，将栈顶元素与出栈队列当前元素对比，相同则出栈，不同则继续入栈
 * 最后，判断栈是否为空
 **/
public class StackPushAndPopList {
    private static boolean isPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int aPushA : pushA) {
            stack.push(aPushA);
            while (!stack.isEmpty() && popA[index] == stack.peek()) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popB1 = {4,5,3,2,1};
        int[] popB2 = {4,3,5,1,2};
        System.out.println(isPopOrder(pushA,popB1));
        System.out.println(isPopOrder(pushA,popB2));
    }
}
