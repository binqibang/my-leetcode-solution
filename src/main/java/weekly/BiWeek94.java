package weekly;

public class BiWeek94 {
    public int captureForts(int[] forts) {
        int l = 0, r = 0;
        int ans = 0;
        while (r < forts.length) {
            if (forts[l] * forts[r] < 0) {
                ans = Math.max(ans,r - l - 1);
            }
            if (forts[r] != 0) {
                l = r;
            }
            r++;
        }
        return ans;
    }
}
