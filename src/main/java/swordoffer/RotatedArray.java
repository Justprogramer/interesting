package swordoffer;

/**
 * @author: Penger
 * @time: 2019/3/23
 * @description: <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * </p>
 * @solution: 使用二分查找
 **/
public class RotatedArray {
    private static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return findWithLoop(array, 0, array.length - 1);
    }

    /**
     * 递归查询最小
     *
     * @param array 数组
     * @param begin 起始
     * @param end   结束
     * @return 最小值
     */
    private static int findMin(int[] array, int begin, int end) {
        int mid = (begin + end) / 2;
        if (begin < end) {
            if (array[mid] < array[end]) {
                return findMin(array, begin, mid);
            }
            if (array[mid] > array[end]) {
                return findMin(array, mid + 1, end);
            }
            if (array[mid] == array[end]) {
                return findMin(array, begin, end - 1);
            }
        }
        return array[mid];
    }

    /**
     * 循环查询最小
     *
     * @param array 数组
     * @param begin 起始
     * @param end   结束
     * @return 最小值
     */
    private static int findWithLoop(int[] array, int begin, int end) {
        while (begin < end) {
            int mid = (begin + end) / 2;
            if (array[mid] < array[end]) {
                end = mid;
            } else if (array[mid] > array[end]) {
                begin = mid + 1;
            } else if (array[mid] == array[end]) {
                end = end - 1;
            }
        }
        return array[begin];
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 5, 1, 2};
        System.out.println(minNumberInRotateArray(a));
        int[] a2 = {1, 1, 1, 0, 1, 1, 1, 1, 1};
        System.out.println(minNumberInRotateArray(a2));
    }

}
