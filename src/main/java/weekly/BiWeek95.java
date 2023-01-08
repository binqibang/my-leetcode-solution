package weekly;

/**
 * LeetCode Biweekly-Contest-95
 * @author binqibang
 * @date 2022/1/8
 */
public class BiWeek95 {
    public String categorizeBox(int length, int width, int height, int mass) {
        long volume = (long) length * width * height;
        boolean isBulky = false, isHeavy = false;
        if (length >= 1e4 || width >= 1e4 || height >= 1e4 || volume >= 1e9) {
            isBulky = true;
        }
        if (mass >= 100) {
            isHeavy = true;
        }
        if (isHeavy && isBulky) {
            return "Both";
        } else if (isHeavy && !isBulky) {
            return "Heavy";
        } else if (!isHeavy && isBulky) {
            return "Bulky";
        } else {
            return "Neither";
        }
    }

    public int xorBeauty(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

}
