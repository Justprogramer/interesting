package com.tao.leetcode;

import java.util.HashMap;
import java.util.Optional;

/**
 * @author: Penger
 * @time: 2019/8/7
 * @description: <p>LRU算法的设计原则是：如果一个数据在最近一段时间没有被访问到，那么在将来它被访问的可能性也很小。
 * 也就是说，当限定的空间已存满数据时，应当把最久没有被访问到的数据淘汰
 * </p>
 **/
public class CustomLru<K, V> {
    class LruNode {
        LruNode pre;
        LruNode next;
        K key;
        V value;

        LruNode(K key, V value, LruNode pre, LruNode next) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
            Optional.ofNullable(next).ifPresent(node -> node.pre = this);
        }
    }

    private int maxCapacity;
    private int size;
    private HashMap<K, LruNode> map;
    private LruNode head;
    private LruNode tail;

    private CustomLru(int capacity) {
        this.maxCapacity = capacity;
        this.size = 0;
        this.map = new HashMap<>(capacity);
        this.head = null;
        this.tail = null;
    }

    private void put(K k, V v) {
        Optional.ofNullable(map.get(k)).map(node -> {
            if (node == head) {
                node.value = v;
                return node;
            }
            node.value = v;
            removeNode(node);
            moveToHead(node);
            return true;
        }).orElseGet(() -> {
            if (size >= maxCapacity) {
                map.remove(tail.key);
                removeNode(tail);
            } else {
                size++;
            }
            if (head == null) {
                head = tail = new LruNode(k, v, null, null);
            } else {
                head = new LruNode(k, v, null, head);
            }
            map.put(k, head);
            return true;
        });
    }

    public V get(K k) {
        return Optional.ofNullable(map.get(k)).map(node -> {
            if (node == head) {
                return node.value;
            }
            removeNode(node);
            moveToHead(node);
            return node.value;
        }).orElse(null);
    }

    public V remove(K k) {
        return Optional.ofNullable(map.get(k)).map(node -> {
            if (node == head) {
                head = node.next;
                head.pre = null;
            }
            removeNode(node);
            size--;
            return node.value;
        }).orElse(null);
    }

    public void clear() {
        head = null;
        tail = null;
        map.clear();
    }

    private void removeNode(LruNode node) {
        Optional.ofNullable(node).ifPresent(cur -> {
            Optional.ofNullable(cur.pre).ifPresent(n -> n.next = cur.next);
            Optional.ofNullable(cur.next).ifPresent(n -> n.pre = cur.pre);
            if (cur == tail) {
                tail = cur.pre;
            }
            cur.pre = null;
            cur.next = null;
        });
    }

    private void moveToHead(LruNode node) {
        Optional.ofNullable(node).ifPresent(n -> {
            n.next = head;
            head.pre = n;
            n.pre = null;
            head = n;
        });
    }

    public static void main(String[] args) {
        CustomLru<Integer, Integer> cache = new CustomLru<>(2);
        cache.put(1, 1);
        cache.put(2, 2);
        // 返回  1
        System.out.println(cache.get(1));
        // 该操作会使得密钥 2 作废
        cache.put(3, 3);
        // 返回 null (未找到)
        System.out.println(cache.get(2));
        // 该操作会使得密钥 1 作废
        cache.put(4, 4);
        // 返回 null (未找到)
        System.out.println(cache.get(1));
        // 返回  3
        System.out.println(cache.get(3));
        // 返回  4
        System.out.println(cache.get(4));
    }
}
