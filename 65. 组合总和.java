import java.util.*;

// 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

// candidates 中的数字可以无限制重复被选取。

// 说明：

// 所有数字（包括 target）都是正整数。
// 解集不能包含重复的组合。 
// 示例 1:

// 输入: candidates = [2,3,6,7], target = 7,
// 所求解集为:
// [
//   [7],
//   [2,2,3]
// ]
// 示例 2:

// 输入: candidates = [2,3,5], target = 8,
// 所求解集为:
// [
//   [2,2,2,2],
//   [2,3,3],
//   [3,5]
// ]

class Solution_65 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int len = candidates.length;
        Arrays.sort(candidates);

        dfs(candidates, len, 0, new ArrayDeque<Integer>(), target, ans);
        return ans;
    }

    public void dfs(int[] candidates, int len, int begin, ArrayDeque<Integer> path, int rest, List<List<Integer>> ans) {
        if (rest == 0) {
            ans.add(new ArrayList<>(path));
        }
        ArrayDeque<Integer> next_path = path;
        for (int i = begin; i < len; i++) {
            if (candidates[i] > rest) {
                break;
            }
            next_path.addLast(candidates[i]);
            dfs(candidates, len, i, next_path, rest - candidates[i], ans);
            next_path.removeLast();
        }
    }

    public static void main(String args[]) {
        Solution_65 solution = new Solution_65();
        int[] candidates_1 = { 2, 3, 6, 7 }, candidates_2 = { 2, 3, 5 };
        int target_1 = 7, target_2 = 8;
        System.out.println(solution.combinationSum(candidates_1, target_1).toString());
        System.out.println(solution.combinationSum(candidates_2, target_2).toString());
    }
}