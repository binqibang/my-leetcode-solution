package string;

/**
 * @author binqibang
 */
public class TestString {
    public static void main(String[] args) {
        LongestUncommonSubsequence sol = new LongestUncommonSubsequence();
        String[] test = new String[] {"aba","aba","aba","abad","abad"};
        System.out.println(sol.findLUSlength2(test));
    }
}
