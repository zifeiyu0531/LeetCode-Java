import java.util.*;

// 输入一个字符串，打印出该字符串中字符的所有排列。

//  

// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

//  

// 示例:

// 输入：s = "abc"
// 输出：["abc","acb","bac","bca","cab","cba"]
//  

// 限制：

// 1 <= s 的长度 <= 8
class Solution_251 {
    List<String> res = new ArrayList<>();

    public String[] permutation(String s) {
        List<Character> chList = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            chList.add(ch);
        }
        dfs(new StringBuilder(), chList);
        return res.toArray(new String[0]);
    }

    private void dfs(StringBuilder sb, List<Character> chList) {
        List<Character> layer = new ArrayList<>();
        for (char ch : chList) {
            if (layer.contains(ch)) {
                continue;
            }
            layer.add(ch);
            StringBuilder tmpSb = new StringBuilder(sb);
            tmpSb.append(ch);
            List<Character> tmpList = new ArrayList<>(chList);
            tmpList.remove((Character) ch);
            if (tmpList.isEmpty()) {
                res.add(tmpSb.toString());
            }
            dfs(tmpSb, tmpList);
        }
    }

    public static void main(String args[]) {
        Solution_251 solution = new Solution_251();
        String s = "abc";
        System.out.println(Arrays.toString(solution.permutation(s)));
    }
}