package hashmap;

import java.util.*;

/**
 * LeetCode #49 (Medium); HOT 100
 * @author binqibang
 * @date 2022/12/15
 */
public class GroupAnagrams {
    /**
     * 方法一：排序
     * @TimeComplexity O(nklogk)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // 在内容相同情况下，`String`会哈希得到相同的`key`；
        // `char[]`由于特殊机制，相同内容的在哈希后值不会相同
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            // 对两个字符串分别进行排序之后得到的字符串相同的，
            // 故可以将排序之后的字符串作为哈希表的键
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 方法二：计数
     * @TimeComplexity O(nk)
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] count = new char[26];
            for (char ch : str.toCharArray()) {
                count[ch-'a']++;
            }
            // 将频次表转`String`作为哈希表的键
            String key = String.valueOf(count);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
