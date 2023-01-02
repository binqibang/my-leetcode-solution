package weekly;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode Weekly-Contest-324
 * @author binqibang
 * @date 2022/12/24
 */
public class Week324 {

    public int similarPairs(String[] words) {
        int ans = 0, n = words.length;
        for (int i = 0; i < n; i++) {
            Set<Character> set1 = new HashSet<>();
            for (char ch : words[i].toCharArray()) {
                set1.add(ch);
            }
            for (int j = i + 1; j < n; j++) {
                Set<Character> set2 = new HashSet<>();
                for (char ch : words[j].toCharArray()) {
                    set2.add(ch);
                }
                if (set1.equals(set2)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int smallestValue(int n) {
        int pre = 0;
        while (n != pre) {
            pre = n;
            int sum = 0;
            for (int i = 2; i * i <= n; ++i) {
                while (n % i == 0) {
                    sum += i; n /= i;
                }
            }
            sum += n > 1 ? n : 0;
            n = sum;
        }
        return n;
    }

}
