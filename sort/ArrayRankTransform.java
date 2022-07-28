package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode #1331 (Easy)
 * @author binqibang
 * @date 2022/7/28
 */
public class ArrayRankTransform {
    public static int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) {
            return new int[] {};
        }
        var ans = arr.clone();
        Arrays.sort(arr);
        Map<Integer, Integer> ranks = new HashMap<>();
        int rank = 1, num = arr[0];
        ranks.put(num, rank);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != num) {
                rank++;
                num = arr[i];
                ranks.put(num, rank);
            }
        }

        /*
        * 更优雅的写法，利用哈希表的长度
        * for (int a : arr) {
        *    if (!ranks.containsKey(a)) {
        *        ranks.put(a, ranks.size() + 1);
        *    }
        * }
        */

        for (int i = 0; i < ans.length; i++) {
            ans[i] = ranks.get(ans[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = new int[] {37,12,28,9,100,56,80,5,12};
        var res = arrayRankTransform(test);
        System.out.println(Arrays.toString(res));
    }
}
