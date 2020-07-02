import java.util.*;

// 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
// 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。

//  

// 示例：

// matrix = [
//    [ 1,  5,  9],
//    [10, 11, 13],
//    [12, 13, 15]
// ],
// k = 8,

// 返回 13。
//  

// 提示：
// 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。

class Solution_131 {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length, columns = matrix[0].length;
        int[] sorted = new int[rows * columns];
        int index = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sorted[index++] = num;
            }
        }
        Arrays.sort(sorted);
        return sorted[k - 1];
    }

    public static void main(String args[]) {
        Solution_131 solution = new Solution_131();
        int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        int k = 8;
        System.out.println(solution.kthSmallest(matrix, k));
    }
}