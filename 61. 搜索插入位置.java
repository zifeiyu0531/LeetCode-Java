// 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

// 你可以假设数组中无重复元素。

// 示例 1:

// 输入: [1,3,5,6], 5
// 输出: 2
// 示例 2:

// 输入: [1,3,5,6], 2
// 输出: 1
// 示例 3:

// 输入: [1,3,5,6], 7
// 输出: 4
// 示例 4:

// 输入: [1,3,5,6], 0
// 输出: 0

class Solution_61 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String args[]) {
        Solution_61 solution = new Solution_61();
        int[] nums_1 = { 1, 3, 5, 6 }, nums_2 = { 1, 3, 5, 6 }, nums_3 = { 1, 3, 5, 6 }, nums_4 = { 1, 3, 5, 6 };
        int target_1 = 5, target_2 = 2, target_3 = 7, target_4 = 0;
        System.out.println(solution.searchInsert(nums_1, target_1));
        System.out.println(solution.searchInsert(nums_2, target_2));
        System.out.println(solution.searchInsert(nums_3, target_3));
        System.out.println(solution.searchInsert(nums_4, target_4));
    }
}