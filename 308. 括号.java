import java.util.*;
// 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。

// 说明：解集不能包含重复的子集。

// 例如，给出 n = 3，生成结果为：

// [
//   "((()))",
//   "(()())",
//   "(())()",
//   "()(())",
//   "()()()"
// ]
class Solution_308 {
    private List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        String str = "(";
        dfs(str, n - 1, n);
        return res;
    }

    private void dfs(String s, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(s);
        }
        if (left > 0) {
            String str = s + '(';
            dfs(str, left - 1, right);
        }
        if (right > 0 && right > left) {
            String str = s + ')';
            dfs(str, left, right - 1);
        }
    }

    public static void main(String args[]) {
        Solution_308 solution = new Solution_308();
        int n = 3;
        System.out.println(solution.generateParenthesis(n).toString());
    }
}