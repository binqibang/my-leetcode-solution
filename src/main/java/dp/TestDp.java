package dp;

/**
 * @author binqibang
 */
public class TestDp {
    public static void main(String[] args) {
        OnesZeroes solution = new OnesZeroes();
        String[] test = new String[] {"10", "0001", "111001", "1", "0"};
        System.out.println(solution.findMaxForm1(test, 5, 3));
    }
}
