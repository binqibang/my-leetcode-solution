package map;

public class Test {
    public static void main(String[] args) {
        String[] words = new String[] {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        FindReplacePattern sol = new FindReplacePattern();
        var res = sol.findAndReplacePattern(words, pattern);
        for(String word : res) {
            System.out.println(word);
        }
    }
}
