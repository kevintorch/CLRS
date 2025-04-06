package clrs.Part_1_Foundations.chapter_02.HybridMergeSort;

import java.util.Arrays;
import java.util.Random;

public class SortBenchmark {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000};
        int[] kValues = {4, 8, 16, 32, 64, 128};
        Random rand = new Random();

        for (int size : sizes) {
            System.out.println("\nArray size: " + size);
            int[] baseArray = new int[size];
            for (int i = 0; i < size; i++) {
                baseArray[i] = rand.nextInt(1_000_000);
            }

            for (int k : kValues) {
                int[] testArray = Arrays.copyOf(baseArray, size);
                long startTime = System.nanoTime();
                HybridMergeSort.sort(testArray, k);
                long endTime = System.nanoTime();
                double duration = (endTime - startTime) / 1e6; // convert to milliseconds

                System.out.printf("  k = %-3d → Time: %.3f ms%n", k, duration);
            }
        }
    }
}
