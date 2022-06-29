package map;

/**
 * Tests for map questions
 * @author binqibang
 */
public class Test {
    public static void main(String[] args) {
        // TestString FindReplacePattern
        String[] words = new String[] {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        FindReplacePattern sol = new FindReplacePattern();
        var res = sol.findAndReplacePattern(words, pattern);
        for(String word : res) {
            System.out.println(word);
        }

        // TestString RandomPickWithBlacklist
        RandomPickWithBlacklist sol1 = new RandomPickWithBlacklist(10, new int[] {2,5});
        for (int i = 0; i < 50; i++) {
            System.out.printf("%d ", sol1.pick());
        }
        System.out.println();

        String test = "http://binqibang.org.cn";
        EncodeDecodeTinyURL sol2 = new EncodeDecodeTinyURL();
        String tiny = sol2.encode(test);
        System.out.println(tiny);
        System.out.println(sol2.decode(tiny));

    }
}
