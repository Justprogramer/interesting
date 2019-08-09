package com.tao.algorithm;

/**
 * @author: Penger
 * @time: 2019/8/9
 * @description: <p>
 * 并查集
 * </p>
 **/
public class UnionFind {
    /**
     * 每个节点序号表示该节点名称，存储内容表示该节点父节点
     */
    private int[] id;
    /**
     * 每个节点序号表示该节点名称，存储内容表示节点的子节点数目
     */
    private int[] size;
    /**
     * 节点总数
     */
    private int count;

    public UnionFind(int capacity) {
        id = new int[capacity];
        size = new int[capacity];
        count = capacity;
        for (int i = 0; i < capacity; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    /**
     * 查找某个节点的父节点
     */
    public int find(int p) {
        while (p != id[p]) {
            // 将p节点的父节点设置为它的爷爷节点,以缩短树的高度
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    /**
     * 判断节点x和节点y是否联合
     */
    public Boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    /**
     * 将节点x和节点y联合，联合规则是大树当小树的父节点
     */
    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return;
        }
        if (size[x] >= size[y]) {
            id[y] = x;
            size[x] += size[y];
        } else {
            id[x] = y;
            size[y] += size[x];
        }
    }
}
