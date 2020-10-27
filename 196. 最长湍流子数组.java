// 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：

// 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
// 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
// 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。

// 返回 A 的最大湍流子数组的长度。

//  

// 示例 1：

// 输入：[9,4,2,10,7,8,8,1,9]
// 输出：5
// 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
// 示例 2：

// 输入：[4,8,12,16]
// 输出：2
// 示例 3：

// 输入：[100]
// 输出：1
//  

// 提示：

// 1 <= A.length <= 40000
// 0 <= A[i] <= 10^9

class Solution_196 {
    public int maxTurbulenceSize(int[] A) {
        int n = A.length;
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = A[0] == A[1] ? 1 : 2;
        int max = Math.max(dp[0], dp[1]);
        for (int i = 2; i < n; i++) {
            if (A[i] == A[i - 1]) {
                dp[i] = 1;
            } else {
                dp[i] = 2;
            }
            if (A[i - 1] > Math.max(A[i], A[i - 2]) || A[i - 1] < Math.min(A[i], A[i - 2])) {
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String args[]) {
        Solution_196 solution = new Solution_196();
        int[] A_1 = { 9, 4, 2, 10, 7, 8, 8, 1, 9 }, A_2 = { 4, 8, 12, 16 }, A_3 = { 100 };
        System.out.println(solution.maxTurbulenceSize(A_1));
        System.out.println(solution.maxTurbulenceSize(A_2));
        System.out.println(solution.maxTurbulenceSize(A_3));
    }
}