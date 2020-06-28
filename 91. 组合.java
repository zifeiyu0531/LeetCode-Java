import java.util.*;

// 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

// 示例:

// 输入: n = 4, k = 2
// 输出:
// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]

class Solution_91 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        backTrace(ans, n, k, new ArrayDeque<Integer>(), 1);
        return ans;
    }

    public void backTrace(List<List<Integer>> ans, int n, int k, Deque<Integer> dq, int start) {
        if (dq.size() == k) {
            ans.add(new ArrayList<Integer>(dq));
            return;
        }
        for (int i = start; i <= n; i++) {
            dq.addLast(i);
            backTrace(ans, n, k, dq, i + 1);
            dq.removeLast();
        }
    }

    public static void main(String args[]) {
        Solution_91 solution = new Solution_91();
        int n = 4;
        int k = 2;
        System.out.println(solution.combine(n, k).toString());
    }
}