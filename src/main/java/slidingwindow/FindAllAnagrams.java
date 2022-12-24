package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode #438 (Medium); HOT 100
 * @author binqibang
 * @date 2022/12/22
 */
public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        List<Integer> ans = new ArrayList<>();
        if (sLen < pLen) {
            return ans;
        }
        int[] pCount = new int[26], sCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i)-'a']++;
            sCount[s.charAt(i)-'a']++;
        }
        if (Arrays.equals(pCount, sCount)) {
            ans.add(0);
        }
        for (int i = 0; i < sLen - pLen; i++) {
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + pLen) - 'a']++;
            if (Arrays.equals(pCount, sCount)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
