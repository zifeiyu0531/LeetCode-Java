import java.util.*;

// 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

//  

// 示例 1：

// 输入：m = 2, n = 3, k = 1
// 输出：3
// 示例 2：

// 输入：m = 3, n = 1, k = 0
// 输出：1
// 提示：

// 1 <= n,m <= 100
// 0 <= k <= 20

class Node_210 {
    public int i;
    public int j;

    public Node_210(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution_210 {
    public int movingCount(int m, int n, int k) {
        int[][] array = new int[m][n];
        Queue<Node_210> queue = new LinkedList<>();
        queue.offer(new Node_210(0, 0));
        array[0][0] = -1;
        int count = 0;
        while (!queue.isEmpty()) {
            Node_210 node = queue.poll();
            count++;
            check(node.i + 1, node.j, array, queue, k);
            check(node.i, node.j + 1, array, queue, k);
            check(node.i - 1, node.j, array, queue, k);
            check(node.i, node.j - 1, array, queue, k);
        }
        return count;
    }

    private void check(int i, int j, int[][] array, Queue<Node_210> queue, int k) {
        if (i < 0 || j < 0 || i > array.length - 1 || j > array[0].length - 1 || array[i][j] == -1) {
            return;
        }
        int sum = 0, temp_i = i, temp_j = j;
        while (temp_i > 0) {
            sum += temp_i % 10;
            temp_i /= 10;
        }
        while (temp_j > 0) {
            sum += temp_j % 10;
            temp_j /= 10;
        }
        if (sum <= k) {
            array[i][j] = -1;
            queue.offer(new Node_210(i, j));
        }
    }

    public static void main(String args[]) {
        Solution_210 solution = new Solution_210();
        int m_1 = 2, m_2 = 3;
        int n_1 = 3, n_2 = 1;
        int k_1 = 1, k_2 = 0;
        System.out.println(solution.movingCount(m_1, n_1, k_1));
        System.out.println(solution.movingCount(m_2, n_2, k_2));
    }
}