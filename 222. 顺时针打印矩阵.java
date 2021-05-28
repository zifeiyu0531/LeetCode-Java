import java.util.*;
// 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

//  

// 示例 1：

// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
// 输出：[1,2,3,6,9,8,7,4,5]
// 示例 2：

// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//  

// 限制：

// 0 <= matrix.length <= 100
// 0 <= matrix[i].length <= 100
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
class Solution_222 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int size = m * n;
        int[] result = new int[size];
        int idx = 0;
        int dir = 0;
        int i = 0;
        int j = -1;
        while (idx < size) {
            switch (dir) {
                case 0:
                    for (int temp = 0; temp < n; temp++) {
                        j++;
                        result[idx] = matrix[i][j];
                        idx++;
                    }
                    m--;
                    break;
                case 1:
                    for (int temp = 0; temp < m; temp++) {
                        i++;
                        result[idx] = matrix[i][j];
                        idx++;
                    }
                    n--;
                    break;
                case 2:
                    for (int temp = 0; temp < n; temp++) {
                        j--;
                        result[idx] = matrix[i][j];
                        idx++;
                    }
                    m--;
                    break;
                case 3:
                    for (int temp = 0; temp < m; temp++) {
                        i--;
                        result[idx] = matrix[i][j];
                        idx++;
                    }
                    n--;
                    break;
            }
            dir = (dir + 1) % 4;
        }
        return result;
    }

    public static void main(String args[]) {
        Solution_222 solution = new Solution_222();
        int[][] matrix_1 = {{1,2,3},{4,5,6},{7,8,9}}, matrix_2 =  {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(Arrays.toString(solution.spiralOrder(matrix_1)));
        System.out.println(Arrays.toString(solution.spiralOrder(matrix_2)));
    }
}