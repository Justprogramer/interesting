package com.tao.pingankeji;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * @author: Penger
 * @time: 2019/9/23
 * @description: <p>
 * </p>
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Character> deque = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (count == 0) {
                deque.addLast(input.charAt(i));
                count++;
                continue;
            }
            if (input.charAt(i) - deque.peekLast() == 1) {
                deque.addLast(input.charAt(i));
                count++;
            } else {
                if (count >= 4) {
                    Character peek = deque.peekLast();
                    while (count > 1) {
                        deque.pollLast();
                        count--;
                    }
                    deque.addLast('-');
                    deque.addLast(peek);
                }
                deque.addLast(input.charAt(i));
                count = 1;
            }
        }
        if (count >= 4) {
            Character peek = deque.peekLast();
            while (count > 1) {
                deque.pollLast();
                count--;
            }
            deque.addLast('-');
            deque.addLast(peek);
        }
        for (Character c : deque) {
            System.out.print(c + "");
        }
    }
}
