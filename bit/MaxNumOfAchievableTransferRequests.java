package bit;

import java.util.Arrays;

/**
 * Question: LeetCode #1601 (Hard)
 * @author binqibang
 * @date 2022/2/28
 */
public class MaxNumOfAchievableTransferRequests {
    public static int maximumRequests(int n, int[][] requests) {
        int[] delta = new int[n];
        int ans = 0, m = requests.length;
        for (int mask = 0; mask < (1 << m); ++mask) {
            // 二进制各位1的个数
            int cnt = Integer.bitCount(mask);
            if (cnt <= ans) {
                continue;
            }
            Arrays.fill(delta, 0);
            for (int i = 0; i < m; ++i) {
                // 选择该搬迁
                if ((mask & (1 << i)) != 0) {
                    ++delta[requests[i][0]];
                    --delta[requests[i][1]];
                }
            }
            boolean flag = true;
            for (int x : delta) {
                if (x != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = cnt;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] test = new int[3][2];
        test[0] = new int[]{0, 0};
        test[1] = new int[]{0, 1};
        test[2] = new int[]{1, 0};
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[i].length; j++) {
                if(j < test[i].length - 1){
                    System.out.printf(" %d ",test[i][j]);
                } else {
                    System.out.printf(" %d\n",test[i][j]);
                }
            }
        }
        System.out.println(maximumRequests(3, test));
        System.out.println(Integer.bitCount(0));
        System.out.println((1 << 2));
    }

}
