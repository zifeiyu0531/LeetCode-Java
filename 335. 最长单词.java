import java.util.*;

// 给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。若有多个长度相同的结果，返回其中字典序最小的一项，若没有符合要求的单词则返回空字符串。

// 示例：

// 输入： ["cat","banana","dog","nana","walk","walker","dogwalker"]
// 输出： "dogwalker"
// 解释： "dogwalker"可由"dog"和"walker"组成。
// 提示：

// 0 <= len(words) <= 200
// 1 <= len(words[i]) <= 100
class Solution_335 {
    public String longestWord(String[] words) {
        String res = "";
        List<String> list = Arrays.asList(words);
        list.sort((a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());
        for (String target : list) {
            if (dfs(target, 0, list)) {
                return target;
            }
        }
        return res;
    }

    private boolean dfs(String target, int start, List<String> list) {
        if (start == target.length()) {
            return true;
        }
        for (int end = start; end < target.length(); end++) {
            if (end - start + 1 == target.length()) {
                continue;
            }
            String subStr = target.substring(start, end + 1);
            if (list.contains(subStr) && dfs(target, end + 1, list)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Solution_335 solution = new Solution_335();
        String[] words = { "cat", "banana", "dog", "nana", "walk", "walker", "dogwalker" };
        System.out.println(solution.longestWord(words));
    }
}