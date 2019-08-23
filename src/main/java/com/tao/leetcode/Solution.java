package com.tao.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    @Test
    public void test() {
        countOfAtoms("(Cm39)5(Ga28Sb45Rb8)20(Bk13Fr29As)45");
    }

    public String countOfAtoms(String formula) {
        Map<String, Integer> countMap = count(formula, 0);
        TreeMap<String, Integer> treeMap = new TreeMap<>(countMap);
        return toResult(treeMap);
    }

    private final String TO_INDEX = "$TO";// 解析到哪里了

    /**
     * @param formula
     * @param from
     * @return
     */
    private Map<String, Integer> count(String formula, int from) {

        int i = from;
        Map<String, Integer> result = new HashMap<>();
        while (i < formula.length()) {
            char c = formula.charAt(i);
            switch (c) {
                case '(':
                    Map<String, Integer> count = count(formula, i + 1);
                    i = count.get(TO_INDEX);
                    // 向后找数字
                    int num = 0;
                    while (i < formula.length()) {
                        char n = formula.charAt(i);
                        if (n >= '0' && n <= '9') {
                            num = num * 10 + n - '0';
                            ++i;
                        } else {
                            break;
                        }
                    }
                    if (num == 0) {
                        num = 1;
                    }
                    // 合并结果
                    for (Map.Entry<String, Integer> e : count.entrySet()) {
                        int v = result.getOrDefault(e.getKey(), 0) + e.getValue() * num;
                        result.put(e.getKey(), v);
                    }
                    break;
                case ')':
                    result.put(TO_INDEX, i + 1);
                    return result;
                default:
                    i = getAtomString(formula, i, result);
            }
        }
        return result;
    }

    /**
     * 找到from后面的第一个元素，并把数里合并到result中，返回解析到什么位置，包含
     *
     * @param s
     * @param from
     * @param result
     * @return
     */
    private int getAtomString(String s, int from, Map<String, Integer> result) {
        int end = from + 1;
        int charEnd = from;
        int num = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (isStop(c)) {
                // 大写字母，停止
                break;
            } else if (c >= '0' && c <= '9') {
                // 数字，求出数字
                num = num * 10 + c - '0';
            } else {
                // 小写字母
                charEnd = end;
            }
            ++end;
        }
        // 合并结果
        num = num == 0 ? 1 : num;
        String atom = s.substring(from, charEnd + 1);
        int v = result.getOrDefault(atom, 0);
        result.put(atom, v + num);
        return end;
    }

    /**
     * 该元素是否已经结束
     *
     * @param c
     * @return
     */
    private boolean isStop(char c) {
        return c >= 'A' && c <= 'Z' || c == ')' || c == '(';
    }

    /**
     * 结果按照字典序转为字符串
     *
     * @param treeMap
     * @return
     */
    private String toResult(TreeMap<String, Integer> treeMap) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> e : treeMap.entrySet()) {
            if (TO_INDEX.equals(e.getKey())) {
                continue;
            }
            sb.append(e.getKey());
            if (e.getValue() > 1) {
                sb.append(e.getValue());
            }
        }
        return sb.toString();
    }

}