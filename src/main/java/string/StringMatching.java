package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode #1408 (Easy)
 * @author binqibang
 * @date 2022/8/6
 */
public class StringMatching {
    /**
     * 数组排序后可以减少与长度小于自身的字符串比较的时间 <br>
     * Time: O(n^2); Space: O(1)
     */
    public static List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        Arrays.sort(words, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else if (o1.length() < o2.length()){
                return -1;
            } else {
                return 1;
            }
        });
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (words[j].contains(words[i])) {
                    ans.add(words[i]);
                    // 去重
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        var strs = new String[] {"leetcoder","leetcode","od","hamlet","am"};
        System.out.println(stringMatching(strs));
    }
}
