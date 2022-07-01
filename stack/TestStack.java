package stack;

/**
 * @author binqibang
 */
public class TestStack {
    public static void main(String[] args) {
        MaxNestingDepthOfParentheses sol = new MaxNestingDepthOfParentheses();
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(sol.maxDepth(s));
    }
}
