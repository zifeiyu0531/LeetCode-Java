import java.util.*;
// 绘制直线。有个单色屏幕存储在一个一维数组中，使得32个连续像素可以存放在一个 int 里。屏幕宽度为w，且w可被32整除（即一个 int 不会分布在两行上），屏幕高度可由数组长度及屏幕宽度推算得出。请实现一个函数，绘制从点(x1, y)到点(x2, y)的水平线。

// 给出数组的长度 length，宽度 w（以比特为单位）、直线开始位置 x1（比特为单位）、直线结束位置 x2（比特为单位）、直线所在行数 y。返回绘制过后的数组。

// 示例1:

//  输入：length = 1, w = 32, x1 = 30, x2 = 31, y = 0
//  输出：[3]
//  说明：在第0行的第30位到第31为画一条直线，屏幕表示为[0b000000000000000000000000000000011]
// 示例2:

//  输入：length = 3, w = 96, x1 = 0, x2 = 95, y = 0
//  输出：[-1, -1, -1]
class Solution_301 {
    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        int col = w / 32;
        int row = length / col;
        int[][] map = new int[row][col];

        int left_idx = x1 / 32;
        int right_idx = x2 / 32;
        int start = 31 - (x1 % 32);
        int end = 31 - (x2 % 32);

        for (int j = left_idx + 1; j < right_idx; j++) {
            map[y][j] = -1;
        }
        if (left_idx == right_idx) {
            for (int i = end; i <= start; i++) {
                map[y][left_idx] = map[y][left_idx] | (1 << i);
            }
        } else {
            for (int i = 0; i <= start; i++) {
                map[y][left_idx] = map[y][left_idx] | (1 << i);
            }
            for (int i = end; i <= 31; i++) {
                map[y][right_idx] = map[y][right_idx] | (1 << i);
            }
        }

        int[] res = new int[length];
        int index = 0;
        for (int[] rows : map) {
            for (int element : rows) {
                res[index++] = element;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        Solution_301 solution = new Solution_301();
        int length_1 = 1, length_2 = 3;
        int w_1 = 32, w_2 = 96;
        int x1_1 = 30, x1_2 = 0;
        int x2_1 = 31, x2_2 = 95;
        int y_1 = 0, y_2 = 0;
        System.out.println(Arrays.toString(solution.drawLine(length_1, w_1, x1_1, x2_1, y_1)));
        System.out.println(Arrays.toString(solution.drawLine(length_2, w_2, x1_2, x2_2, y_2)));
    }
}