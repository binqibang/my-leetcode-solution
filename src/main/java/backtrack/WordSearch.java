package backtrack;

/**
 * LeetCode #79 (Medium); HOT 100
 * @author binqibang
 * @date 2022/12/16
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断以网格的 (i, j) 位置出发，能否搜索到单词 word[k..]，
     * 其中 word[k..] 表示字符串 word 从第 k 个字符开始的后缀子串
     */
    private boolean check(char[][] board, int i, int j, String word, int idx) {
        if (idx == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(idx)) {
            return false;
        }
        char c = board[i][j];
        // 防止重复利用
        board[i][j] = '0';
        boolean res = check(board, i + 1, j, word, idx + 1) ||
                check(board, i - 1, j, word, idx + 1) ||
                check(board, i, j + 1, word, idx + 1) ||
                check(board, i, j - 1, word, idx + 1);
        board[i][j] = c;
        return res;
    }
}
