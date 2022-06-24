package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Question: LeetCode #6 (Medium)
 * @author binqibang
 * @date 2022/3/1
 */
public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> store = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            store.add(new StringBuilder());
        }
        // 指示方向，向下时行标+1，向上时行标-1
        boolean direction = false;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            store.get(index).append(s.charAt(i));
            // 触底或触顶时改变方向
            if (index == numRows -1 || index == 0){
                direction = !direction;
            }
            // 行标正向+1，逆向-1
            index = index + (direction ? 1 : -1);
        }
        var res = new StringBuilder();
        for (StringBuilder sb : store) {
            res.append(sb);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String test = input.nextLine();
        int numRows = input.nextInt();
        System.out.println(test);
        System.out.println(convert(test, numRows));
    }
}
