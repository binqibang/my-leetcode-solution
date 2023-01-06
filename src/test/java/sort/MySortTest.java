package sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

class MySortTest {
    private MySort mySort;
    private int[] testArr;
    private int[] testTimeArr;

    @BeforeEach
    void setUp() {
        testArr = new int[] {5, 11, 7, 9, 2, 8, 10, 4, 20};
        mySort = new MySort();
    }

    @Test
    void selectSort() {
        mySort.selectSort(testArr);
    }

    @Test
    void bubbleSort() {
        mySort.bubbleSort(testArr);
    }

    @Test
    void shellSort() {
        mySort.shellSort(testArr);
        System.out.println(Arrays.toString(testArr));
    }

    @Test
    void insertionSort() {
        mySort.insertionSort(testArr);
    }

    @Test
    void mergeSort() {
        mySort.topDownMergeSort(testArr);
        System.out.println(Arrays.toString(testArr));
    }

    @Test
    void quickSort() {
        mySort.quickSort(testArr);
        System.out.println(Arrays.toString(testArr));
    }

    @Test
    void testTime() {
        final int N = 100000;
        testTimeArr = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            testTimeArr[i] = random.nextInt(100000);
        }
        // SelectSort
        var begin = System.nanoTime();
        mySort.selectSort(testTimeArr);
        var end = System.nanoTime();
        System.out.printf("SelectSort: %.4f ms\n", (end - begin) / 1e6);
        // BubbleSort
        begin = System.nanoTime();
        mySort.bubbleSort(testTimeArr);
        end = System.nanoTime();
        System.out.printf("BubbleSort: %.4f ms\n", (end - begin) / 1e6);
        // InsertionSort
        begin = System.nanoTime();
        mySort.insertionSort(testTimeArr);
        end = System.nanoTime();
        System.out.printf("InsertionSort: %.4f ms\n", (end - begin) / 1e6);
        // ShellSort
        begin = System.nanoTime();
        mySort.shellSort(testTimeArr);
        end = System.nanoTime();
        System.out.printf("ShellSort: %.4f ms\n", (end - begin) / 1e6);
        // MergeSort
        begin = System.nanoTime();
        mySort.topDownMergeSort(testTimeArr);
        end = System.nanoTime();
        System.out.printf("MergeSort: %.4f ms\n", (end - begin) / 1e6);
        // QuickSort
        begin = System.nanoTime();
        mySort.quickSort(testTimeArr);
        end = System.nanoTime();
        System.out.printf("QuickSort: %.4f ms\n", (end - begin) / 1e6);
    }
}