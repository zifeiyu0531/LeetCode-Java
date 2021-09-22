import java.util.*;

// 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

//  

// 示例 1:

// 输入: "abcabcbb"
// 输出: 3 
// 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 示例 2:

// 输入: "bbbbb"
// 输出: 1
// 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 示例 3:

// 输入: "pwwkew"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//  

// 提示：

// s.length <= 40000
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
class Solution_256 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = -1, res = 0;
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                i = Math.max(i, map.get(ch));
            }
            map.put(ch, j);
            res = Math.max(res, j - i);
        }
        return res;
    }

    public static void main(String args[]) {
        Solution_256 solution = new Solution_256();
        String s_1 = "abcabcbb", s_2 = "bbbbb", s_3 = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(s_1));
        System.out.println(solution.lengthOfLongestSubstring(s_2));
        System.out.println(solution.lengthOfLongestSubstring(s_3));
    }
}