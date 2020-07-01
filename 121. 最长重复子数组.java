// 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。

// 示例 1:

// 输入:
// A: [1,2,3,2,1]
// B: [3,2,1,4,7]
// 输出: 3
// 解释: 
// 长度最长的公共子数组是 [3, 2, 1]。
// 说明:

// 1 <= len(A), len(B) <= 1000
// 0 <= A[i], B[i] < 100

class Solution_121 {
    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int len = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                len = Math.max(len, dp[i][j]);
            }
        }
        return len;
    }

    public static void main(String args[]) {
        Solution_121 solution = new Solution_121();
        int[] A = { 1, 2, 3, 2, 1 }, B = { 3, 2, 1, 4, 7 };
        System.out.println(solution.findLength(A, B));
    }
}