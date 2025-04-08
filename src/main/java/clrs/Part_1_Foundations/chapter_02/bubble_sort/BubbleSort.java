package clrs.Part_1_Foundations.chapter_02.bubble_sort;

import java.util.Arrays;

public class BubbleSort {

    public static void sort(int[] a, int l, int r) {
        for (int i = l; i < r; i++) {
            for (int j = r; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
                System.out.println(Arrays.toString(a));
            }
        }
    }

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        int[] test = {2, 4, 23, 34, 21, 8, 7, 12};
        sort(test);
    }
}
