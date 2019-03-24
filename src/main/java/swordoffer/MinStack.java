package swordoffer;

import java.util.Stack;

/**
 * @author: Penger
 * @time: 2019/3/24
 * @description: <p>定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * </p>
 * @solution: 用一个栈stack保存数据，用另外一个栈temp保存依次入栈最小的数
 **/
public class MinStack {
    private static Stack<Integer> stack = new Stack<>();
    private static Stack<Integer> minStack = new Stack<>();
    private static int min = Integer.MAX_VALUE;

    public static void push(int node) {
        stack.push(node);
        if (node < min) {
            minStack.push(node);
            min = node;
        } else {
            minStack.push(min);
        }
    }

    public static void pop() {
        stack.pop();
        minStack.pop();
    }

    public static int top() {
        return stack.peek();
    }

    public static int min() {
        return minStack.peek();
    }
}
