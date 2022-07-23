package doublepointers;

/**
 * LeetCode #1437 (Easy)
 * @author binqibang
 * @date 2022/7/23
 */
public class KLengthApart {
    /**
     * 特值：全为0：[0,0,0]; 最后一位为0：[1,0,0,1,0]
     */
    public static boolean kLengthApart(int[] nums, int k) {
        int idx = 0;
        int n = nums.length;
        // first '1'
        while (idx < n && nums[idx] == 0) {
            idx++;
        }
        while (idx < n - 1) {
            int count = 0;
            // 避免数组越界
            while (idx < n - 1 && nums[++idx] == 0) {
                count++;
            }
            // 需判断右边界是否是1
            if (count < k && nums[idx] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] test = new int[] {1,0,0,0,1,0,0,1,0};
        int k = 3;
        System.out.println(kLengthApart(test, k));
    }
}
