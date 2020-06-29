import java.util.*;

// 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

// 说明：解集不能包含重复的子集。

// 示例:

// 输入: [1,2,2]
// 输出:
// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]

class Solution_103 {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrace(nums, new ArrayDeque<Integer>(), 0);
        return ans;
    }

    public void backTrace(int[] nums, Deque<Integer> dq, int start) {
        ans.add(new ArrayList<Integer>(dq));
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            dq.addLast(nums[i]);
            backTrace(nums, dq, i + 1);
            dq.removeLast();
        }
    }

    public static void main(String args[]) {
        Solution_103 solution = new Solution_103();
        int[] nums = { 1, 2, 2 };
        System.out.println(solution.subsetsWithDup(nums).toString());
    }
}