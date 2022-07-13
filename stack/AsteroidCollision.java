package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * LeetCode #735 (Medium) <br>
 * 类似这种相邻元素之间，且难以判断明确结束条件的问题，<br>
 * 一般使用栈模拟,例如括号匹配 <br>
 * Time: O(n); Space: O(n)
 * @author binqibang
 * @date 2022/7/13
 */
public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int aster : asteroids) {
            if (aster > 0) {
                stack.push(aster);
            }
            boolean alive = true;
            while (alive && !stack.isEmpty() && stack.peek() > 0) {
                // 当前行星质量大于栈顶，则存活
                alive = -aster > stack.peek();
                // 当前行星质量大于等于栈顶，栈顶元素爆炸、出栈
                if (-aster >= stack.peek()) {
                    stack.pop();
                }
            }
            if (alive) {
                stack.push(aster);
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        // 此题测试用例貌似都是正数都在前
        int[] test = new int[]{5, 10, 3, -7, 2, -3};
        var ans = asteroidCollision(test);
        System.out.println(Arrays.toString(ans));
    }
}


