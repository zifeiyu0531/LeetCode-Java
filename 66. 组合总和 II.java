import java.util.*;

// 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

// candidates 中的每个数字在每个组合中只能使用一次。

// 说明：

// 所有数字（包括目标数）都是正整数。
// 解集不能包含重复的组合。 
// 示例 1:

// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
// 所求解集为:
// [
//   [1, 7],
//   [1, 2, 5],
//   [2, 6],
//   [1, 1, 6]
// ]
// 示例 2:

// 输入: candidates = [2,5,2,1,2], target = 5,
// 所求解集为:
// [
//   [1,2,2],
//   [5]
// ]

class Solution_66 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            next_path.addLast(candidates[i]);
            dfs(candidates, len, i + 1, next_path, rest - candidates[i], ans);
            next_path.removeLast();
        }
    }

    public static void main(String args[]) {
        Solution_66 solution = new Solution_66();
        int[] candidates_1 = { 10, 1, 2, 7, 6, 1, 5 }, candidates_2 = { 2, 5, 2, 1, 2 };
        int target_1 = 8, target_2 = 5;
        System.out.println(solution.combinationSum2(candidates_1, target_1).toString());
        System.out.println(solution.combinationSum2(candidates_2, target_2).toString());
    }
}