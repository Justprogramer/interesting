package com.tao.leetcode;

import java.util.*;

/**
 * @author: Penger
 * @time: 2019/7/24
 * @description: <p>
 * </p>
 **/
public class LFUCache {
    class Node {
        Integer key;
        Integer value;
        Integer frequency;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }

        void updateFrequency() {
            this.frequency++;
        }

        Node updateNode(Integer value) {
            this.value = value;
            updateFrequency();
            return this;
        }
    }

    private ArrayDeque<Integer> elements;
    private Map<Integer, Node> data;
    private int size;
    private int capacity;

    public LFUCache(int capacity) {
        this.elements = new ArrayDeque<>(capacity);
        this.data = new HashMap<>();
        this.size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        return Optional.ofNullable(data.get(key)).map(node -> {
            elements.removeFirstOccurrence(key);
            elements.addFirst(key);
            node.updateFrequency();
            return node.value;
        }).orElse(-1);
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (data.get(key) == null && size < capacity) {
            data.put(key, new Node(key, value));
            elements.addFirst(key);
            size++;
        } else if (data.get(key) != null) {
            data.put(key, data.get(key).updateNode(value));
            elements.removeFirstOccurrence(key);
            elements.addFirst(key);
        } else {
            removeLFU();
            data.put(key, new Node(key, value));
            elements.addFirst(key);
        }
    }

    private void removeLFU() {
        Iterator<Map.Entry<Integer, Node>> iterator = data.entrySet().stream().sorted(Comparator.comparingInt(o -> o.getValue().frequency)).iterator();
        List<Integer> candidate = new ArrayList<>();
        Map.Entry<Integer, Node> first = iterator.next();
        candidate.add(first.getKey());
        while (iterator.hasNext()) {
            Map.Entry<Integer, Node> next = iterator.next();
            if (first.getValue().frequency.equals(next.getValue().frequency)) {
                candidate.add(next.getKey());
            } else {
                break;
            }
        }
        if (candidate.size() == 1) {
            data.remove(candidate.get(0));
            elements.removeFirstOccurrence(candidate.get(0));
            return;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = elements.size() - 1; i >= 0; i--) {
            Integer key = elements.pollLast();
            if (candidate.contains(key)) {
                data.remove(key);
                break;
            }
            stack.push(key);
        }
        while (!stack.isEmpty()) {
            elements.addLast(stack.pop());
        }
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3, 3);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        lfuCache.put(4, 4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
    }
}
