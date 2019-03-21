package algorithm;

import java.util.Arrays;

/**
 * author: TAOPENG
 * time ： 2019/3/8
 **/
public class BubbleSort {
    public void bubSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] a = {12, 23, 5, 1, 6, 2, 6345, 3, 123, 6};
        bubbleSort.bubSort(a);
        System.out.println(Arrays.toString(a));
    }

}
