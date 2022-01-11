import java.util.*;

// 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

// 请你找出符合题意的 最短 子数组，并输出它的长度。

//  

// 示例 1：

// 输入：nums = [2,6,4,8,10,9,15]
// 输出：5
// 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 示例 2：

// 输入：nums = [1,2,3,4]
// 输出：0
// 示例 3：

// 输入：nums = [1]
// 输出：0
//  

// 提示：

// 1 <= nums.length <= 104
// -105 <= nums[i] <= 105
//  

// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
class Solution_361 {
    public int findUnsortedSubarray(int[] nums) {
        if (isSorted(nums)) {
            return 0;
        }
        int[] numsSorted = new int[nums.length];
        System.arraycopy(nums, 0, numsSorted, 0, nums.length);
        Arrays.sort(numsSorted);
        int left = 0;
        while (nums[left] == numsSorted[left]) {
            left++;
        }
        int right = nums.length - 1;
        while (nums[right] == numsSorted[right]) {
            right--;
        }
        return right - left + 1;
    }

    public boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Solution_361 solution = new Solution_361();
        int[] nums_1 = { 2, 6, 4, 8, 10, 9, 15 }, nums_2 = { 1, 2, 3, 4 }, nums_3 = { 1 };
        System.out.println(solution.findUnsortedSubarray(nums_1));
        System.out.println(solution.findUnsortedSubarray(nums_2));
        System.out.println(solution.findUnsortedSubarray(nums_3));
    }
}