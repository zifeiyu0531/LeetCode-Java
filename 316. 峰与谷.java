import java.util.*;

// 在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。例如，在数组{5, 8, 4, 2, 3, 4, 6}中，{8, 6}是峰， {5, 2}是谷。现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。

// 示例:

// 输入: [5, 3, 1, 2, 3]
// 输出: [5, 1, 3, 2, 3]
// 提示：

// nums.length <= 10000
class Solution_316 {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0) {
                if (nums[i] < nums[i - 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                }
            } else {
                if (nums[i] > nums[i - 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                }
            }
        }
    }

    public static void main(String args[]) {
        Solution_316 solution = new Solution_316();
        int[] nums = { 5, 3, 1, 2, 3 };
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}