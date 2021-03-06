// 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

// 每行中的整数从左到右按升序排列。
// 每行的第一个整数大于前一行的最后一个整数。
// 示例 1:

// 输入:
// matrix = [
//   [1,   3,  5,  7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 50]
// ]
// target = 3
// 输出: true
// 示例 2:

// 输入:
// matrix = [
//   [1,   3,  5,  7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 50]
// ]
// target = 13
// 输出: false

class Solution_89 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m - 1;
        int row = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid][0] == target || matrix[mid][n - 1] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                right = mid - 1;
            } else if (matrix[mid][n - 1] < target) {
                left = mid + 1;
            } else {
                row = mid;
                break;
            }
        }
        if (row == -1) {
            return false;
        }
        left = 0;
        right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Solution_89 solution = new Solution_89();
        int[][] matrix_1 = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
        int[][] matrix_2 = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
        int target_1 = 3, target_2 = 13;
        System.out.println(solution.searchMatrix(matrix_1, target_1));
        System.out.println(solution.searchMatrix(matrix_2, target_2));
    }
}