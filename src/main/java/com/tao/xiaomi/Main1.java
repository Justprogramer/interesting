package com.tao.xiaomi;

import java.util.Scanner;

/*
《2048》是一款热门的数字游戏。游戏中，每个方块上的数字都有2的幂，数字方块会根据指令整体进行上下左右移动，如果两个数字相同的方块在移动中碰撞，他们就会合成一个新的方块。
例如下图为4*4格子的游戏，0表示格子为空，图a为移动前格子中的数字，图b为图a左移后的结果:

0 0 2 4
0 2 2 2
0 4 2 2
8 8 2 2
   图a
2 4 0 0
4 2 0 0
4 4 0 0
16 4 0 0
   图b
问，给定n*m的矩阵M，0表示空格子，非0整数表示待移动的数字，按照2048的移动规则，输出进行左移操作后的矩阵结果。
 */
public class Main1 {

    static void solution(long[][] input) {
        for (int i = 0; i < input.length; i++) {
            int beginIndex = 0;
            for (int j = 0; j < input.length; j++) {
                long current = input[i][j];
                long next = j < input.length - 1 ? input[i][j + 1] : 0;
                if (current == next && current != 0) {
                    input[i][j] = 0;
                    if (j < input.length - 1){
                        input[i][j + 1] = 0;
                    }
                    if (beginIndex < input.length){
                        input[i][beginIndex++] = current << 1;
                    }
                } else if (current != 0) {
                    input[i][j] = 0;
                    if (beginIndex < input.length){
                        input[i][beginIndex++] = current;
                    }
                }
            }
            for (long num : input[i]) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[][] nums = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = in.nextLong();
            }
        }
        solution(nums);
    }
}
