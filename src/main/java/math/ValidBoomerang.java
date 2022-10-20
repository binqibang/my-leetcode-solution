package math;

/**
 * Question: LeetCode #1037 (Easy)
 * @author binqibang
 * @date 2022/6/8
 */
public class ValidBoomerang {
    public static boolean isBoomerang(int[][] points) {
        return (points[1][0] - points[0][0]) * (points[2][1] - points[0][1]) !=
                (points[2][0] - points[0][0]) * (points[1][1] - points[0][1]);
    }

    public static void main(String[] args) {
        int[][] test = new int[][] {{1,1}, {2,2}, {3,3}};
        System.out.println(isBoomerang(test));
    }
}
