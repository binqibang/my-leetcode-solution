package slidingwindow;

/**
 * LeetCode #11 (Medium); HOT 100
 * @author binqibang
 * @date 2022/12/29
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            ans = height[l] < height[r] ?
                    Math.max(ans, (r - l) * height[l++]) :
                    Math.max(ans, (r - l) * height[r--]);
        }
        return ans;
    }
}
