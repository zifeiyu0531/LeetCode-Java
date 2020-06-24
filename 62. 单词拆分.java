import java.util.*;

// 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

// 说明：

// 拆分时可以重复使用字典中的单词。
// 你可以假设字典中没有重复的单词。
// 示例 1：

// 输入: s = "leetcode", wordDict = ["leet", "code"]
// 输出: true
// 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 示例 2：

// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
// 输出: true
// 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//      注意你可以重复使用字典中的单词。
// 示例 3：

// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
// 输出: false

class Solution_62 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String args[]) {
        Solution_62 solution = new Solution_62();
        String s_1 = "leetcode", s_2 = "applepenapple", s_3 = "catsandog";
        String[] array_1 = { "leet", "code" }, array_2 = { "apple", "pen" },
                array_3 = { "cats", "dog", "sand", "and", "cat" };
        List<String> wordDict_1 = Arrays.asList(array_1), wordDict_2 = Arrays.asList(array_2),
                wordDict_3 = Arrays.asList(array_3);
        System.out.println(solution.wordBreak(s_1, wordDict_1));
        System.out.println(solution.wordBreak(s_2, wordDict_2));
        System.out.println(solution.wordBreak(s_3, wordDict_3));
    }
}