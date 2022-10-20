package string;

/**
 * LeetCode #168 (Easy); CodeTop MS
 * @author binqibang
 * @date 2022/10/17
 */
public class ExcelColumnTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        int remainder;
        while (columnNumber > 0) {
            columnNumber--;
            remainder =  columnNumber % 26;
            columnNumber = columnNumber / 26;
            char cur = (char) ('A' + remainder);
            builder.insert(0, cur);
        }
        return builder.toString();
    }
}
