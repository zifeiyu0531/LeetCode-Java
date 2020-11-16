import java.util.*;

// 给定一个矩阵 A， 返回 A 的转置矩阵。

// 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。

//  

// 示例 1：

// 输入：[[1,2,3],[4,5,6],[7,8,9]]
// 输出：[[1,4,7],[2,5,8],[3,6,9]]
// 示例 2：

// 输入：[[1,2,3],[4,5,6]]
// 输出：[[1,4],[2,5],[3,6]]
//  

// 提示：

// 1 <= A.length <= 1000
// 1 <= A[0].length <= 1000

class Solution_201 {
    public int[][] transpose(int[][] A) {
        if (A.length == 0) {
            return new int[0][0];
        }
        int m = A.length, n = A[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][i] = A[i][j];
            }
        }
        return res;
    }

    public static void main(String args[]) {
        Solution_201 solution = new Solution_201();
        int[][] A_1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, A_2 = { { 1, 2, 3 }, { 4, 5, 6 } };
        System.out.println(Arrays.toString(solution.transpose(A_1)));
        System.out.println(Arrays.toString(solution.transpose(A_2)));
    }
}