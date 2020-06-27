// 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

// 说明：每次只能向下或者向右移动一步。

// 示例:

// 输入:
// [
//   [1,3,1],
//   [1,5,1],
//   [4,2,1]
// ]
// 输出: 7
// 解释: 因为路径 1→3→1→1→1 的总和最小。

class Solution_83 {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[] path = new int[m];
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                path[i] = grid[0][i];
            } else {
                path[i] = path[i - 1] + grid[0][i];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    path[j] += grid[i][j];
                } else {
                    int min = Math.min(path[j], path[j - 1]);
                    path[j] = min + grid[i][j];
                }
            }
        }
        return path[m - 1];
    }

    public static void main(String args[]) {
        Solution_83 solution = new Solution_83();
        int[][] grid_1 = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        System.out.println(solution.minPathSum(grid_1));
    }
}