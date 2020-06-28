import java.util.*;

// 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

// 说明：解集不能包含重复的子集。

// 示例:

// 输入: nums = [1,2,3]
// 输出:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]

class Solution_92 {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        backTrace(nums, 0, new ArrayDeque<Integer>());
        Arrays.sort(nums);
        return ans;
    }

    public void backTrace(int[] nums, int start, Deque<Integer> dq) {
        ans.add(new ArrayList<Integer>(dq));
        for (int i = start; i < nums.length; i++) {
            dq.add(nums[i]);
            backTrace(nums, i + 1, dq);
            dq.removeLast();
        }
    }

    public static void main(String args[]) {
        Solution_92 solution = new Solution_92();
        int[] nums = { 1, 2, 3 };
        System.out.println(solution.subsets(nums).toString());
    }
}