package swordoffer;

import java.util.Scanner;

/**
 * @author: Penger
 * @time: 2019/3/24
 * @description: <p>数值的整数次方
 * </p>
 * @solution: 指数为负时，可以先对指数求绝对值，算出次方的结果后再取倒数
 * 当底数为0，指数为负时，会出现对0求倒数情况，要特殊处理
 * 0的0次方在数学上没有意义，因此无论输出0还是1都是可以接受的
 * 在计算次方的时候，除了简单的遍历，我们可以使用递归的思想
 **/
public class Power {

    private static double powerOne(double base, int exponent) {
        if (base == 0 && exponent < 0) {
            throw new RuntimeException("指数小于0，分母不能为0");
        }
        if (exponent == 0) {
            return 1.0;
        } else if (exponent == 1) {
            return base;
        } else if (exponent == -1) {
            return 1.0 / base;
        }
        double result = powerOne(base, exponent / 2) * powerOne(base, exponent / 2);
        if (exponent % 2 == 0) {
            return result;
        } else {
            return result * base;
        }
    }

    /**
     * 使用位移运算代替除法，使用&代替取模
     */
    private static double powerTwo(double base, int exponent) {
        if (base == 0 && exponent < 0) {
            throw new RuntimeException("指数小于0，分母不能为0");
        }
        if (exponent == 0) {
            return 1.0;
        } else if (exponent == 1) {
            return base;
        } else if (exponent == -1) {
            return 1.0 / base;
        }
        double result = powerTwo(base, exponent >> 1) * powerOne(base, exponent >> 1);
        if ((exponent & 0x1) == 0) {
            return result;
        } else {
            return result * base;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input the base and exponent, print base^exponent");
        while (scanner.hasNext()) {
            double base = scanner.nextDouble();
            int exponent = scanner.nextInt();
            System.out.println(powerTwo(base, exponent));
        }
    }
}
