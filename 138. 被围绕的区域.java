import java.util.*;

// 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

// 示例:

// X X X X
// X O O X
// X X O X
// X O X X
// 运行你的函数后，矩阵变为：

// X X X X
// X X X X
// X X X X
// X O X X
// 解释:

// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。

class Solution_138 {
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                changeBorder(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                changeBorder(board, m - 1, j);
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                changeBorder(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                changeBorder(board, i, n - 1);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '-') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void changeBorder(char[][] board, int i, int j) {
        board[i][j] = '-';
        for (int index = 0; index < 4; index++) {
            int temp_i = i, temp_j = j;
            switch (index) {
                case 0: // 左
                    temp_j--;
                    break;
                case 1: // 上
                    temp_i--;
                    break;
                case 2: // 右
                    temp_j++;
                    break;
                case 3: // 下
                    temp_i++;
                    break;
            }
            if (temp_i >= 0 && temp_i < board.length && temp_j >= 0 && temp_j < board[0].length
                    && board[temp_i][temp_j] == 'O') {
                changeBorder(board, temp_i, temp_j);
            }
        }
    }

    public static void main(String args[]) {
        Solution_138 solution = new Solution_138();
        char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' } };
        solution.solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}