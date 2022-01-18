package 牛客TOP100;

class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int sum = dp[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(array[i], array[i] + dp[i - 1]);
            sum = Math.max(sum, dp[i]);
        }
        return sum;
    }
}