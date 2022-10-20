package binarysearch;

import java.util.Scanner;

/**
 * @author binqibang
 * @created 2021/04/07
 */
public class TestRotatedSort {
    public static void main(String[] args) {
        // Search in rotated ordered array test

        // input a non-length-limited array
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] array = str.split(" ");
        int[] test = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            test[i] = Integer.parseInt(array[i]);
        }

        int tar = 0;
        tar = in.nextInt();

        SearchRotatedSortedArray s = new SearchRotatedSortedArray();
        MinimumInRotatedSortedArray m = new MinimumInRotatedSortedArray();
        System.out.println(s.search(test,tar));
        System.out.printf("%d  %d\n",m.findMin(test),m.findMin_1(test));

    }
}
