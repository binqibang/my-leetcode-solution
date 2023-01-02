package weekly;

/**
 * LeetCode Weekly-Contest-325
 * @author binqibang
 * @date 2022/12/29
 */
public class Week325 {

    public int closetTarget(String[] words, String target, int startIndex) {
        if (words[startIndex].equals(target)) {
            return 0;
        }
        int n =  words.length;
        // 向右寻找，第一个找到的`target`即为右最短距离
        int idx = (startIndex + 1) % n, rDis = 1;
        while (idx != startIndex) {
            if (words[idx].equals(target)) {
                break;
            }
            idx = (idx + 1) % n;
            rDis++;
        }
        // 向左寻找，第一个找到的`target`即为左最短距离
        idx = (startIndex - 1 + n) % n;
        int lDis = 1;
        while (idx != startIndex) {
            if (words[idx].equals(target)) {
                break;
            }
            idx = (idx - 1 + n) % n;
            lDis++;
        }
        int dis = Math.min(lDis, rDis);
        return dis == n ? -1 : dis;
    }

    public int takeCharacters(String s, int k) {
        int[] counts = new int[3];
        for (char ch : s.toCharArray()) {
            counts[ch-'a']++;
        }
        for (int c : counts) {
            if (c < k) {
                return -1;
            }
        }
        int[] cur = new int[3];
        int l = 0, r = 0, max = 0;
        while (r < s.length()) {
            int idx = s.charAt(r) - 'a';
            cur[idx]++;
            while (counts[idx] - cur[idx] < k) {
                cur[s.charAt(l++)- 'a']--;
            }
            max = Math.max(max, ++r - l);
        }
        return s.length() - max;
    }
}
