package string;

import java.util.Scanner;

/**
 * Question: LeetCode #1576 (Easy)
 * @author binqibang
 * @@date  2022/1/5
 */
public class ReplaceAllQuestionMarks {
    public static String modifyString(String s){
        char start = 'x';
        char end = 'z';
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (charArray[i] == '?'){
                for (char c = start; c <= end; c++){
                    if ((i > 0 && charArray[i-1] == c) || (i < s.length() -1 && charArray[i+1] == c)){
                        continue;
                    }
                    charArray[i] = c;
                    break;
                }
            }
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        System.out.println(modifyString(str));
    }
}
