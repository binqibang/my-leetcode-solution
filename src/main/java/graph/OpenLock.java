package graph;

import java.util.*;

/**
 * LeetCode #752 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/11/9
 */
public class OpenLock {
    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }

        Set<String> dead = new HashSet<>();
        Collections.addAll(dead, deadends);
        if (dead.contains("0000")) {
            return -1;
        }

        int step = 0;
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("0000");
        Set<String> tried = new HashSet<>();
        tried.add("0000");

        // BFS
        while (!queue.isEmpty()) {
            step++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String code = queue.poll();
                for (String next : getNextCodes(code)) {
                    if (!tried.contains(next) && !dead.contains(next)) {
                        if (next.equals(target)) {
                            return step;
                        }
                        queue.offer(next);
                        tried.add(next);
                    }
                }
            }
        }

        return -1;
    }

    public List<String> getNextCodes(String code) {
        List<String> res = new ArrayList<>();
        char[] next = code.toCharArray();
        for (int i = 0; i < code.length(); i++) {
            char digit = code.charAt(i);
            // 当前位向回转
            next[i] = digit == '0' ? '9' : (char) (digit - 1);
            res.add(new String(next));
            // 当前位向后转
            next[i] = digit == '9' ? '0' : (char) (digit + 1);
            res.add(new String(next));
            // 当前位复原
            next[i] = digit;
        }
        return res;
    }
}
