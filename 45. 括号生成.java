import java.util.*;

// 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

//  

// 示例：

// 输入：n = 3
// 输出：[
//        "((()))",
//        "(()())",
//        "(())()",
//        "()(())",
//        "()()()"
//      ]

class Solution_45 {
    List<String> str_list = new ArrayList<String>();

    public void getList(String s, int open, int close, int max) {
        String temp = s;
        if (s.length() == max * 2) {
            str_list.add(s);
            return;
        }
        if (open < max) {
            temp += "(";
            getList(temp, open + 1, close, max);
        }
        if (open > close) {
            s += ")";
            getList(s, open, close + 1, max);
        }
    }

    public List<String> generateParenthesis(int n) {
        if (n > 0) {
            getList("", 0, 0, n);
        }
        return str_list;
    }

    public static void main(String args[]) {
        Solution_45 solution = new Solution_45();
        int n_1 = 3;
        System.out.println(solution.generateParenthesis(n_1).toString());
    }
}