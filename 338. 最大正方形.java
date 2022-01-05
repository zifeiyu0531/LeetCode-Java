// 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。

//  

// 示例 1：

// 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
// 输出：4
// 示例 2：

// 输入：matrix = [["0","1"],["1","0"]]
// 输出：1
// 示例 3：

// 输入：matrix = [["0"]]
// 输出：0
//  

// 提示：

// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 300
// matrix[i][j] 为 '0' 或 '1'
class Solution_338 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    }
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res * res;
    }

    public static void main(String args[]) {
        Solution_338 solution = new Solution_338();
        char[][] matrix_1 = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        char[][] matrix_2 = { { '0', '1' }, { '1', '0' } };
        char[][] matrix_3 = { { '0' } };
        System.out.println(solution.maximalSquare(matrix_1));
        System.out.println(solution.maximalSquare(matrix_2));
        System.out.println(solution.maximalSquare(matrix_3));
    }
}