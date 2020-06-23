import java.util.*;

// 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

// 注意：

// 答案中不可以包含重复的四元组。

// 示例：

// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

// 满足要求的四元组集合为：
// [
//   [-1,  0, 0, 1],
//   [-2, -1, 1, 2],
//   [-2,  0, 0, 2]
// ]

class Solution_43 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int size = nums.length;
        for (int first = 0; first < size; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < size; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int third = second + 1, fourth = size - 1;
                while (third < fourth) {
                    while (third < fourth && fourth < size - 1 && nums[fourth] == nums[fourth + 1]) {
                        fourth--;
                    }
                    while (third < fourth && third > second + 1 && nums[third] == nums[third - 1]) {
                        third++;
                    }
                    if (third == fourth) {
                        break;
                    }
                    int ans = nums[first] + nums[second] + nums[third] + nums[fourth];
                    if (ans > target) {
                        fourth--;
                    } else if (ans < target) {
                        third++;
                    } else {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[first]);
                        temp.add(nums[second]);
                        temp.add(nums[third]);
                        temp.add(nums[fourth]);
                        res.add(temp);
                        fourth--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
        Solution_43 solution = new Solution_43();
        int[] nums_1 = { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        System.out.println(solution.fourSum(nums_1, target).toString());
    }
}