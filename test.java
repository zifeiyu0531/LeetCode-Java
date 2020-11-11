import java.util.*;

class Solution {
    public int getLongestPalindrome(String A, int n) {
        if (n <= 1) {
            return n;
        }
        int dp = 1;
        for (int i = 1; i < n; i++) {
            dp = Math.max(dp, getPalindrome(A.substring(0, i + 1)));
        }
        return dp;
    }

    private int getPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(s.length() - 1)) {
                StringBuilder sb = new StringBuilder(s.substring(i, s.length()));
                if (sb.equals(sb.reverse())) {
                    return s.length() - i;
                }
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        String A = "ccbcabaabba";
        int n = 11;
        System.out.println(solution.getLongestPalindrome(A, n));
    }
}