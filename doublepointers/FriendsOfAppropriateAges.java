package doublepointers;

import java.util.Arrays;

/**
 * LeetCode #825 (Medium)
 * @author binqibang
 * @date 2022/7/14
 */
public class FriendsOfAppropriateAges {
    /**
     * 双指针法寻找的是左右边界，如果条件满足单调性，可以先进行排序 <br>
     * 左定界，右扩展 <br>
     * Time: O(nlogn); Space: O(n)
     */
    public static int numFriendRequests(int[] ages) {
        int ans = 0, n = ages.length;
        Arrays.sort(ages);
        int left = 0, right = 0;
        for (int age : ages) {
            if (age < 15) {
                continue;
            }
            // 左指针 left 不满足 ages[left] > ages[x] * 0.5 + 7，向后移动
            while (ages[left] <= 0.5 * age + 7) {
                left++;
            }
            // 右指针 right+1 满足 ages[right+1] <= ages[x]，向后移动
            while (right + 1 < n && ages[right + 1] <= age) {
                right++;
            }
            ans += (right - left);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = new int[] {16,16,16,17,18};
        System.out.println(numFriendRequests(test));
    }
}
