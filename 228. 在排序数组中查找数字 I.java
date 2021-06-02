// 统计一个数字在排序数组中出现的次数。

//  

// 示例 1:

// 输入: nums = [5,7,7,8,8,10], target = 8
// 输出: 2
// 示例 2:

// 输入: nums = [5,7,7,8,8,10], target = 6
// 输出: 0
//  

// 限制：

// 0 <= 数组长度 <= 50000

//  

// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
class Solution_228 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                for(int i = left; i <= right; i++){
                    if(nums[i] == target){
                        res++;
                    }
                }
                break;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        Solution_228 solution = new Solution_228();
        int[] nums_1 = { 5, 7, 7, 8, 8, 10 }, nums_2 = { 5, 7, 7, 8, 8, 10 };
        int target_1 = 8, target_2 = 6;
        System.out.println(solution.search(nums_1, target_1));
        System.out.println(solution.search(nums_2, target_2));
    }
}