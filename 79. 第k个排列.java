// 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// 给定 n 和 k，返回第 k 个排列。

// 说明：

// 给定 n 的范围是 [1, 9]。
// 给定 k 的范围是[1,  n!]。
// 示例 1:

// 输入: n = 3, k = 3
// 输出: "213"
// 示例 2:

// 输入: n = 4, k = 9
// 输出: "2314"

class Solution_79 {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        boolean[] used = new boolean[n];
        bfs(n, k, sb, array, used);
        return sb.toString();
    }

    public void bfs(int n, int k, StringBuilder sb, int[] array, boolean[] used) {
        if (sb.length() == array.length) {
            return;
        }
        int n_1 = 1;
        for (int i = 2; i < n; i++) {
            n_1 *= i;
        }
        int read = 0;
        for (int i = 0; i < array.length; i++) {
            if (used[i]) {
                continue;
            }
            read += n_1;
            if (read < k) {
                continue;
            }
            sb.append(array[i]);
            used[i] = true;
            bfs(n - 1, k - read + n_1, sb, array, used);
            if (read >= k) {
                break;
            }
        }
    }

    public static void main(String args[]) {
        Solution_79 solution = new Solution_79();
        int n_1 = 3, n_2 = 4;
        int k_1 = 3, k_2 = 9;
        System.out.println(solution.getPermutation(n_1, k_1));
        System.out.println(solution.getPermutation(n_2, k_2));
    }
}