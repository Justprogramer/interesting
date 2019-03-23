package swordoffer;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author: Penger
 * @time: 2019/3/23
 * @description: <p> 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * </p>
 * @solution: 堆是先进后出的，队列是先进先出的，所以使用一个堆stack1进行push，另一个堆stack2进行pop
 * stack2的堆为空时，就将stack1的堆进行pop，将数据push到stack2
 **/
public class StackToQueue {
    public static Stack<Integer> stack1 = new Stack<>();
    public static Stack<Integer> stack2 = new Stack<>();

    public static void push(int node) {
        stack1.push(node);
    }

    public static int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入100内的数字：");
        Random random = new Random();
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            for (int i = 0; i < num; i++) {
                int node = random.nextInt(100);
                System.out.println(node);
                push(node);
            }
            System.out.println("使用pop:");
            for (int i = 0; i < num; i++) {
                System.out.println(pop());
            }
        }
    }
}
