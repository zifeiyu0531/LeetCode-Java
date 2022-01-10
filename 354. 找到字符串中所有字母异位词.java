import java.util.*;

// 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。

//  

// 示例 1:

// 输入: s = "cbaebabacd", p = "abc"
// 输出: [0,6]
// 解释:
// 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
// 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
//  示例 2:

// 输入: s = "abab", p = "ab"
// 输出: [0,1,2]
// 解释:
// 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
// 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
// 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
//  

// 提示:

// 1 <= s.length, p.length <= 3 * 104
// s 和 p 仅包含小写字母
class Solution_354 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) {
            return res;
        }
        int[] sCnt = new int[26];
        int[] pCnt = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sCnt[s.charAt(i) - 'a']++;
            pCnt[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCnt, pCnt)) {
            res.add(0);
        }
        for (int start = 1; start <= s.length() - p.length(); start++) {
            sCnt[s.charAt(start - 1) - 'a']--;
            sCnt[s.charAt(start + p.length() - 1) - 'a']++;
            if (Arrays.equals(sCnt, pCnt)) {
                res.add(start);
            }
        }
        return res;
    }

    public static void main(String args[]) {
        Solution_354 solution = new Solution_354();
        String s_1 = "cbaebabacd", s_2 = "abab";
        String p_1 = "abc", p_2 = "ab";
        System.out.println(solution.findAnagrams(s_1, p_1).toString());
        System.out.println(solution.findAnagrams(s_2, p_2).toString());
    }
}