package weekly;

import java.util.PriorityQueue;

public class Week331 {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int g : gifts) {
            maxHeap.offer(g);
        }
        for (int i = 0; i < k; i++) {
            if (maxHeap.peek() > 1) {
                maxHeap.offer((int) Math.sqrt(maxHeap.poll()));
            } else {
                break;
            }
        }
        long ans = 0;
        for (int e : maxHeap) {
            ans += e;
        }
        return ans;
    }


    private static final String VOWELS = "aeiou";

    private boolean check(String word) {
        int n = word.length();
        return VOWELS.contains(word.substring(0, 1)) && VOWELS.contains(word.substring(n - 1, n));
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] preSum = new int[words.length + 1];
        for (int i = 0; i < words.length; i++) {
            preSum[i+1] = preSum[i];
            if (check(words[i])) {
                preSum[i+1]++;
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            ans[i] = preSum[query[1]+1] - preSum[query[0]];
        }
        return ans;
    }



}
