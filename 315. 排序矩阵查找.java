// 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。

// 示例:

// 现有矩阵 matrix 如下：

// [
//   [1,   4,  7, 11, 15],
//   [2,   5,  8, 12, 19],
//   [3,   6,  9, 16, 22],
//   [10, 13, 14, 17, 24],
//   [18, 21, 23, 26, 30]
// ]
// 给定 target = 5，返回 true。

// 给定 target = 20，返回 false。
class Solution_315 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        return dfs(matrix, 0, matrix[0].length - 1, target);
    }

    private boolean dfs(int[][] matrix, int i, int j, int target) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return false;
        }
        if (target == matrix[i][j]) {
            return true;
        }
        return target < matrix[i][j] ? dfs(matrix, i, j - 1, target) : dfs(matrix, i + 1, j, target);
    }

    public static void main(String args[]) {
        Solution_315 solution = new Solution_315();
        int[][] matrix = {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }
        };
        int target_1 = 5, target_2 = 20;
        System.out.println(solution.searchMatrix(matrix, target_1));
        System.out.println(solution.searchMatrix(matrix, target_2));
    }
}