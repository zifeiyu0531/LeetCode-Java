import java.util.HashMap;
import java.util.Map;

// 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。

//  

// 示例 1：

// 输入：nums = [1,1,1], k = 2
// 输出：2
// 示例 2：

// 输入：nums = [1,2,3], k = 3
// 输出：2
//  

// 提示：

// 1 <= nums.length <= 2 * 104
// -1000 <= nums[i] <= 1000
// -107 <= k <= 107
class Solution_360 {
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            pre += num;
            count += map.getOrDefault(pre - k, 0);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String args[]) {
        Solution_360 solution = new Solution_360();
        int[] nums_1 = { 1, 1, 1 }, nums_2 = { 1, 2, 3 };
        int k_1 = 2, k_2 = 3;
        System.out.println(solution.subarraySum(nums_1, k_1));
        System.out.println(solution.subarraySum(nums_2, k_2));
    }
}