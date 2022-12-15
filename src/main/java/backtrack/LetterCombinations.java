package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * LeetCode #17 (Medium); HOT 100
 * @author binqibang
 * @date 2022/12/15
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = Map.of(
                '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
        );
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    private void backtrack(List<String> combinations, Map<Character, String> phoneMap,
                           String digits, int idx, StringBuffer combination) {
        if (idx == digits.length()) {
            combinations.add(combination.toString());
            return;
        }
        String letters = phoneMap.get(digits.charAt(idx));
        for (int i = 0; i < letters.length(); i++) {
            combination.append(letters.charAt(i));
            backtrack(combinations, phoneMap, digits, idx + 1, combination);
            combination.deleteCharAt(idx);
        }
    }
}
