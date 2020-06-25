import java.util.*;

// 给定一个可包含重复数字的序列，返回所有不重复的全排列。

// 示例:

// 输入: [1,1,2]
// 输出:
// [
//   [1,1,2],
//   [1,2,1],
//   [2,1,1]
// ]

class Solution_69 {
    public void backtrack(int[] nums, ArrayDeque<Integer> path, List<List<Integer>> res, boolean[] used, int depth) {
        if (depth == nums.length) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i != 0 && nums[i] == nums[i - 1]&& !used[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            backtrack(nums, path, res, used, depth + 1);
            used[i] = false;
            path.removeLast();
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayDeque<Integer>(), res, used, 0);
        return res;
    }

    public static void main(String args[]) {
        Solution_69 solution = new Solution_69();
        int[] nums_1 = { 1, 1, 2 };
        System.out.println(solution.permuteUnique(nums_1).toString());
    }
}