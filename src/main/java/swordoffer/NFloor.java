package swordoffer;

import java.util.Scanner;

/**
 * @author: Penger
 * @time: 2019/3/25
 * @description: <p>一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 * </p>
 * @solution: f(n) = 2 * f(n-1)
 * f(n) = f(1) + f(2) + …… + f(n-2) + f(n-1)  f(n) 表示n级台阶有一次1,2,...n阶的 跳法数。
 * f(n-1) = f(1) + f(2) + …… + f(n-2)
 * 所以 f(n) = 2 * f(n-1)
 **/
public class NFloor {

    /**
     * n阶台阶问题，每次可以跳1，2，3，... , n阶
     */
    private static int floor(int n) {
        if (n <= 1) {
            return 1;
        }
        return floor(n - 1) << 1;
    }

    /**
     * n阶台阶问题，每次只能跳1级·或者2级
     */
    private static int floorSimple(int n) {
        if (n <= 1) {
            return 1;
        }
        int sum = 0;
        int first = 0;
        int second = 1;
        for (int i = 1; i <= n; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(floor(scanner.nextInt()));
            System.out.println(floorSimple(scanner.nextInt()));
        }
    }
}
