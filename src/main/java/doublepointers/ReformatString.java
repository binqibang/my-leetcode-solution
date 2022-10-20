package doublepointers;

/**
 * LeetCode #1417 (Easy)
 * @author binqibang
 * @date 2022/8/11
 */
public class ReformatString {
    public String reformat(String s) {
        int numDigit = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                numDigit++;
            }
        }
        int numAlpha = s.length() - numDigit;
        if (Math.abs(numDigit - numAlpha) > 1) {
            return "";
        }
        int i = 0, j = 0;
        if (numDigit > numAlpha) {
            j++;
        } else {
            i++;
        }
        char[] ans = new char[s.length()];
        for (int k = 0; k < ans.length; k++) {
            var ch = s.charAt(k);
            if (Character.isDigit(ch)) {
                ans[i] = ch;
                i += 2;
            } else {
                ans[j] = ch;
                j += 2;
            }
        }
        return new String(ans);
    }

    private void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
