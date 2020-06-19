import java.util.*;

// 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。

// 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。

//  

// 示例 1：

// 输入：nums = [2,5,1,3,4,7], n = 3
// 输出：[2,3,5,4,1,7] 
// 解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
// 示例 2：

// 输入：nums = [1,2,3,4,4,3,2,1], n = 4
// 输出：[1,4,2,3,3,2,4,1]
// 示例 3：

// 输入：nums = [1,1,2,2], n = 2
// 输出：[1,2,1,2]
//  

// 提示：

// 1 <= n <= 500
// nums.length == 2n
// 1 <= nums[i] <= 10^3

class Solution_4 {
    public int[] shuffle(int[] nums, int n) {
        int[] resort = new int[2 * n];
        for (int i = 0, j = 0; i < 2 * n; i += 2, j++) {
            resort[i] = nums[j];
            resort[i + 1] = nums[j + n];
        }
        return resort;
    }

    public static void main(String args[]) {
        Solution_4 solution = new Solution_4();
        int[] nums_1 = { 2, 5, 1, 3, 4, 7 }, nums_2 = { 1, 2, 3, 4, 4, 3, 2, 1 }, nums_3 = { 1, 1, 2, 2 };
        int n_1 = 3, n_2 = 4, n_3 = 2;
        System.out.println(Arrays.toString(solution.shuffle(nums_1, n_1)));
        System.out.println(Arrays.toString(solution.shuffle(nums_2, n_2)));
        System.out.println(Arrays.toString(solution.shuffle(nums_3, n_3)));
    }
}