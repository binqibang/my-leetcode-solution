package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode #93 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/9/29
 */
public class RestoreIpAddresses {
    private static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<>();
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return ans;
        }
        dfs(s, 0, 0);
        return ans;
    }

    private void dfs(String s, int segId, int segIdx) {
        // 找到 4 段 IP 地址且遍历完字符串，则得到一个正确答案；
        // 否则回溯至上一段继续遍历
        if (segId == SEG_COUNT) {
            if (segIdx == s.length()) {
                StringBuilder ip = new StringBuilder();
                for (int i = 0; i < SEG_COUNT; i++) {
                    ip.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ip.append('.');
                    }
                }
                ans.add(ip.toString());
            }
            return;
        }

        // 没有找到 4 段 IP 地址就已经遍历完了字符串，提前回溯
        if (segIdx == s.length()) {
            return;
        }

        // 当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segIdx) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segIdx + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        int seg = 0;
        for (int i = segIdx; i < s.length(); i++) {
            seg = seg * 10 + (s.charAt(i) - '0');
            if (seg > 0 && seg <= 255) {
                segments[segId] = seg;
                dfs(s, segId + 1, i + 1);
            } else {
                break;
            }
        }
    }
}
