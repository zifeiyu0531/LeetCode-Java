import java.util.*;

class Solution {
    public boolean isPalindrome(String str) {
        Stack<Character> stack = new Stack<Character>();
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }
        for (char ch : str.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "ababaa";
        System.out.println(solution.isPalindrome(str));
    }
}