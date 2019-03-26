package swordoffer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: Penger
 * @time: 2019/3/26
 * @description: <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * </p>
 * @solution: <p>
 * 方法一：使用一个map记录每个数字存在的次数，每次更新时判断是否超过一半，超过了直接返回当前数字；遍历结束还没有超过一般的直接返回0
 * 方法二：将数组排序，取中位数，统计中位数的次数是否超过一半
 * 方法三：某个数字出现的次数大于数组长度的一半，意思就是它出现的次数比其他所有数字出现的次数和还要多。
 * 因此我们可以在遍历数组的时候记录两个值：1. 数组中的数字;2. 次数。
 * 遍历下一个数字时，若它与之前保存的数字相同，则次数加1，否则次数减1；若次数为0，则保存下一个数字，并将次数置为1。
 * 遍历结束后，所保存的数字即为所求。最后再判断它是否符合条件
 * </p>
 **/
public class MoreThanHalfNumber {
    private static int moreThanHalfNum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int a : array) {
            result.merge(a, 1, (oldValue, newValue) -> oldValue + newValue);
            if (result.get(a) > (array.length >> 1)) {
                return a;
            }
        }
        return 0;
    }

    private int moreThanHalfNumTWO(int[] array) {
        Arrays.sort(array);
        int half = array.length / 2;
        int count = 0;
        for (int anArray : array) {
            if (anArray == array[half]) {
                count++;
            }
        }
        if (count > half) {
            return array[half];
        } else {
            return 0;
        }
    }

    public int moreThanHalfNumThree(int[] array) {
        int res = array[0], count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == res) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res = array[i];
                count = 1;
            }
        }
        count = 0;
        for (int anArray : array) {
            if (anArray == res) {
                count++;
            }
        }
        return count > array.length / 2 ? res : 0;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(moreThanHalfNum(array));
    }
}
