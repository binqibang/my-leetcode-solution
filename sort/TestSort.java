package sort;

import java.util.Arrays;

/**
 * @author binqibang
 */
public class TestSort {
    public static void main(String[] args) {
        WiggleSort sort = new WiggleSort();
        int[] test = new int[] {5,5,5,4,4,4,4};
        sort.wiggleSort1(test);
        System.out.println(Arrays.toString(test));
    }
}
