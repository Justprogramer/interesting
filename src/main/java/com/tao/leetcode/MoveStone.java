package com.tao.leetcode;

import java.util.HashSet;

/**
 * @author: Penger
 * @time: 2019/8/9
 * @description: <p>
 * 在二维平面上，我们将石头放置在一些整数坐标点上。每个坐标点上最多只能有一块石头。
 * 现在，move 操作将会移除与网格上的某一块石头共享一列或一行的一块石头。
 * 我们最多能执行多少次 move 操作？
 * <p>
 * 示例 1：
 * 输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * 输出：3
 * <p>
 * 示例 3：
 * 输入：stones = [[0,0]]
 * 输出：0
 * <p>
 * 提示：
 * 1 <= stones.length <= 1000
 * 0 <= stones[i][j] < 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 * @solution: <p>
 * 首先将处于同一行或同一列的石头两两相连，这样会产生一个图。在这个图里面，互相连通的石子组成一个连通分量。
 * 显然，总有办法将一个连通分量中的石子依次移除，直到只剩下一个。
 * 首先，我们要知道每个石子都属于一个连通分量，同时在一个连通分量中移除石子不会影响到其他的连通分量。
 * 在有了这个前提之下，我们可以推断出，如果把连通分量作为一个生成树来看，每次都移除树中的叶子节点，重复这个操作，最后就只会剩下一个根节点。
 * </p>
 **/
public class MoveStone {
    private int[] position;
    private int[] size;

    public int removeStones(int[][] stones) {
        position = new int[20000];
        size = new int[20000];
        for (int i = 0; i < 20000; i++) {
            position[i] = i;
            size[i] = 1;
        }
        //使用并查集，需要将二维转成一维，原本一个石头的(x，y)，在一维情况下，可以将他们当作是连通的两个节点
        for (int[] stone : stones) {
            union(stone[0], stone[1] + 10000);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int[] stone : stones) {
            set.add(find(stone[0]));
        }

        return stones.length - set.size();
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return;
        }
        if (size[x] >= size[y]) {
            size[x] += size[y];
            position[y] = x;
        } else {
            size[y] += size[x];
            position[x] = y;
        }
    }

    private int find(int x) {
        while (x != position[x]) {
            position[x] = position[position[x]];
            x = position[x];
        }
        return x;
    }
}
