// 设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。

// 以下是井字游戏的规则：

// 玩家轮流将字符放入空位（" "）中。
// 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
// "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
// 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
// 当所有位置非空时，也算为游戏结束。
// 如果游戏结束，玩家不允许再放置字符。
// 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。

// 示例 1：

// 输入： board = ["O X"," XO","X O"]
// 输出： "X"
// 示例 2：

// 输入： board = ["OOX","XXO","OXO"]
// 输出： "Draw"
// 解释： 没有玩家获胜且不存在空位
// 示例 3：

// 输入： board = ["OOX","XXO","OX "]
// 输出： "Pending"
// 解释： 没有玩家获胜且仍存在空位
// 提示：

// 1 <= board.length == board[i].length <= 100
// 输入一定遵循井字棋规则
class Solution_318 {
    public String tictactoe(String[] board) {
        int n = board.length;
        int[][] mat = new int[n][n];
        boolean pendding = false;
        for (int i = 0; i < n; i++) {
            String str = board[i];
            for (int j = 0; j < n; j++) {
                char ch = str.charAt(j);
                if (ch == 'X') {
                    mat[i][j] = 1;
                } else if (ch == 'O') {
                    mat[i][j] = -1;
                } else {
                    pendding = true;
                }
            }
        }

        int result_left = 0, result_right = 0;
        for (int i = 0; i < n; i++) {
            int result_row = 0, result_col = 0;
            for (int j = 0; j < n; j++) {
                result_row += mat[i][j];
                result_col += mat[j][i];
                if (i == j) {
                    result_left += mat[i][j];
                }
                if (i + j == n - 1) {
                    result_right += mat[i][j];
                }
            }
            if (result_row == n || result_col == n) {
                return "X";
            } else if (result_row == -n || result_col == -n) {
                return "O";
            }
        }

        if (result_left == n || result_right == n) {
            return "X";
        }else if (result_left == -n || result_right == -n) {
            return "O";
        }

        if(pendding){
            return "Pending";
        }
        return "Draw";
    }

    public static void main(String args[]) {
        Solution_318 solution = new Solution_318();
        String[] board_1 = { "O X", " XO", "X O" };
        String[] board_2 = { "OOX", "XXO", "OXO" };
        String[] board_3 = { "OOX", "XXO", "OX " };
        System.out.println(solution.tictactoe(board_1));
        System.out.println(solution.tictactoe(board_2));
        System.out.println(solution.tictactoe(board_3));
    }
}