import java.util.*;

// 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。

// 示例 1：

// 输入: s1 = "abc", s2 = "bca"
// 输出: true 
// 示例 2：

// 输入: s1 = "abc", s2 = "bad"
// 输出: false
// 说明：

// 0 <= len(s1) <= 100
// 0 <= len(s2) <= 100
class Solution_266 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            map.put(ch1, map.getOrDefault(ch1, 0) + 1);
            map.put(ch2, map.getOrDefault(ch2, 0) - 1);
        }
        for (char ch : map.keySet()) {
            if (map.get(ch) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Solution_266 solution = new Solution_266();
        String s1_1 = "abc", s1_2 = "abc";
        String s2_1 = "bca", s2_2 = "bad";
        System.out.println(solution.CheckPermutation(s1_1, s2_1));
        System.out.println(solution.CheckPermutation(s1_2, s2_2));
    }
}