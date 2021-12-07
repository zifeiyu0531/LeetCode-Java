import java.util.*;
// 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。

// 示例1:

//  输入：S = "qqe"
//  输出：["eqq","qeq","qqe"]
// 示例2:

//  输入：S = "ab"
//  输出：["ab", "ba"]
// 提示:

// 字符都是英文字母。
// 字符串长度在[1, 9]之间。
class Solution_307 {
    List<String> res;

    public String[] permutation(String S) {
        res = new ArrayList<>();
        dfs(S.toCharArray(), 0);
        return res.toArray(new String[0]);
    }

    private void dfs(char[] c, int k) {
        if (k == c.length) {
            res.add(new String(c));
        }
        Set<Character> set = new HashSet<>();
        for (int i = k; i < c.length; i++) {
            if (!set.contains(c[i])) {
                set.add(c[i]);
                swap(c, i, k);
                dfs(c, k + 1);
                swap(c, i, k);
            }
        }
    }

    private void swap(char[] c, int i, int j) {
        char ch = c[i];
        c[i] = c[j];
        c[j] = ch;
    }

    public static void main(String args[]) {
        Solution_307 solution = new Solution_307();
        String S_1 = "qqe", S_2 = "ab";
        System.out.println(Arrays.toString(solution.permutation(S_1)));
        System.out.println(Arrays.toString(solution.permutation(S_2)));
    }
}