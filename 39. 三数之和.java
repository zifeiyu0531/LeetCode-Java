import java.util.*;

// 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

// 注意：答案中不可以包含重复的三元组。

//  

// 示例：

// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

// 满足要求的三元组集合为：
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]

class Solution_39 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int size = nums.length;
        for (int first = 0; first < size; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = size - 1;
            for (int second = first + 1; second < size; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > -nums[first]) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == -nums[first]) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[first]);
                    temp.add(nums[second]);
                    temp.add(nums[third]);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
        Solution_39 solution = new Solution_39();
        int[] nums_1 = { -1, 0, 1, 2, -1, -4 };
        System.out.println(solution.threeSum(nums_1).toString());
    }
}