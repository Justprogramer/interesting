package com.tao.leetcode;

import org.junit.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: Penger
 * @time: 2019/7/23
 * @description: <p>
 * 给定一个化学式formula（作为字符串），返回每种原子的数量。
 * 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
 * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
 * 两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。
 * 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
 * 给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推
 * 输入:
 * formula = "Mg(OH)2"
 * 输出: "H2MgO2"
 * 解释:
 * 原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
 * <p>
 * 输入:
 * formula = "K4(ON(SO3)2)2"
 * 输出: "K4N2O14S4"
 * 解释:
 * 原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-atoms
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 **/
public class CountOfAtoms {

    @Test
    public void test() {
        System.out.println(countOfAtoms("Mg(OH)2"));
    }

    public String countOfAtoms(String formula) {
        if (formula.length() < 2) {
            return formula;
        }
        TreeMap<String, Integer> result = parse(formula, 0);
        StringBuilder sb = new StringBuilder();
        for (String key : result.keySet()) {
            sb.append(key);
            if (result.get(key) > 1) {
                sb.append(result.get(key));
            }
        }
        return sb.toString();
    }


    private TreeMap<String, Integer> parse(String formula, int start) {
        Integer num;
        StringBuilder sb = new StringBuilder();
        String rightBracket = ")";
        TreeMap<String, Integer> result = new TreeMap<>(Comparator.naturalOrder());
        for (int i = start; i < formula.length(); i++) {
            char cur = formula.charAt(i);
            if (cur <= 'Z' && cur >= 'A') {
                if (sb.length() != 0) {
                    result.merge(sb.toString(), 1, Integer::sum);
                    sb = new StringBuilder();
                }
                sb.append(cur);
            } else if (cur <= 'z' && cur >= 'a') {
                sb.append(cur);
            } else if (cur <= '9' && cur >= '0') {
                num = extractNum(i, formula);
                i = i + num.toString().length() - 1;
                result.merge(sb.toString(), num, Integer::sum);
                sb = new StringBuilder();
            } else if (cur == '(') {
                if (sb.length() != 0) {
                    result.merge(sb.toString(), 1, Integer::sum);
                }
                sb = new StringBuilder();
                TreeMap<String, Integer> tempResultMap = parse(formula, i + 1);
                int rightBracketIndex = tempResultMap.remove(rightBracket);
                int exp = extractNum(rightBracketIndex + 1, formula);
                i = rightBracketIndex + String.valueOf(exp).length();
                // 合并结果
                for (Map.Entry<String, Integer> e : tempResultMap.entrySet()) {
                    int v = result.getOrDefault(e.getKey(), 0) + e.getValue() * exp;
                    result.put(e.getKey(), v);
                }
            } else if (cur == ')') {
                if (sb.length() != 0) {
                    result.merge(sb.toString(), 1, Integer::sum);
                }
                result.put(rightBracket, i);
                return result;
            }
        }
        if (sb.length() != 0) {
            result.merge(sb.toString(), 1, Integer::sum);
        }
        return result;
    }


    private int extractNum(int start, String formula) {
        int num = 0;
        for (int j = start; j < formula.length(); j++) {
            char next = formula.charAt(j);
            if (next < '0' || next > '9') {
                break;
            }
            num = num * 10 + next - '0';
        }
        return num == 0 ? 1 : num;
    }

}
