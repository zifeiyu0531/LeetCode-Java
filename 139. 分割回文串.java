import java.util.*;

// 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

// 返回 s 所有可能的分割方案。

// 示例:

// 输入: "aab"
// 输出:
// [
//   ["aa","b"],
//   ["a","a","b"]
// ]

class Solution_139 {
    List<List<String>> ans;

    public List<List<String>> partition(String s) {
        ans = new ArrayList<List<String>>();
        backTrace(s, 0, new ArrayDeque<String>());
        return ans;
    }

    public void backTrace(String s, int start, Deque<String> path) {
        int n = s.length();
        if (start == n) {
            ans.add(new ArrayList<String>(path));
            return;
        }
        for (int i = start; i < n; i++) {
            String str = s.substring(start, i + 1);
            if (isPalindrome(str)) {
                path.addLast(str);
                backTrace(s, i + 1, path);
                path.removeLast();
            }
        }
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String args[]) {
        Solution_139 solution = new Solution_139();
        String s = "aab";
        System.out.println(solution.partition(s).toString());
    }
}