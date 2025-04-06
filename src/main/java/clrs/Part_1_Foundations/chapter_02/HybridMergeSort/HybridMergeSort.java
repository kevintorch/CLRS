package clrs.Part_1_Foundations.chapter_02.HybridMergeSort;

import java.util.Arrays;

public class HybridMergeSort {

    private static final int MAX_INSERTION_SORT_SIZE = 32;

    public static void sort(int[] arr) {
        hybridMergeSort(arr, 0, arr.length - 1, MAX_INSERTION_SORT_SIZE);
    }

    public static void sort(int[] arr, int k) {
        hybridMergeSort(arr, 0, arr.length - 1, k);
    }

    private static void hybridMergeSort(int[] arr, int left, int right, int k) {
        if (right - left + 1 <= k) {
            insertionSort(arr, left, right);
        } else if (left < right) {
            int mid = (left + right) / 2;
            hybridMergeSort(arr, left, mid, k);
            hybridMergeSort(arr, mid + 1, right, k);
            merge(arr, left, mid, right);
        }
    }

    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;

        while (i < leftArr.length && j < rightArr.length) {
            arr[k++] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++];
        }

        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }
}
