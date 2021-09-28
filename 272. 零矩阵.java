// 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。

//  

// 示例 1：

// 输入：
// [
//   [1,1,1],
//   [1,0,1],
//   [1,1,1]
// ]
// 输出：
// [
//   [1,0,1],
//   [0,0,0],
//   [1,0,1]
// ]
// 示例 2：

// 输入：
// [
//   [0,1,2,0],
//   [3,4,5,2],
//   [1,3,1,5]
// ]
// 输出：
// [
//   [0,0,0,0],
//   [0,4,5,0],
//   [0,3,1,0]
// ]
class Solution_272 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row_mark = new boolean[m];
        boolean[] col_mark = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row_mark[i] = true;
                    col_mark[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row_mark[i] || col_mark[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String args[]) {
        Solution_272 solution = new Solution_272();
        int[][] matrix_1 = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        int[][] matrix_2 = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        solution.setZeroes(matrix_1);
        solution.setZeroes(matrix_2);
    }
}