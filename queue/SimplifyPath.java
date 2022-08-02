package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Question: LeetCode #71 (Medium)
 * @author binqibang
 * @created 2022/1/6
 */
public class SimplifyPath {
    public static String simplifyPath(String path){
        String[] directories = path.split("/");
        Deque<String> deque = new ArrayDeque<>();
        for (String dir:directories) {
            if ("..".equals(dir)) {
                if (!deque.isEmpty()){
                    deque.pollLast();
                }
            } else if (dir.length() > 0 && !".".equals(dir)){
                deque.push(dir);
            }
        }
        StringBuilder res = new StringBuilder();
        if (deque.isEmpty()){
            res.append('/');
        } else {
            while (!deque.isEmpty()){
                res.append('/');
                res.append(deque.pollFirst());
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        System.out.println(simplifyPath(str));
    }
}
