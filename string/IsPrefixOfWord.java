package string;

/**
 * LeetCode #1455 (Easy)
 * @author binqibang
 * @date 2022/8/21
 */
public class IsPrefixOfWord {
    public static int isPrefixOfWord(String sentence, String searchWord) {
        var words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String sentence = "i love eating burger", searchWord = "burg";
        System.out.println(isPrefixOfWord(sentence, searchWord));
    }
}
