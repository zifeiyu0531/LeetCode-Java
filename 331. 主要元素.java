// 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。

//  

// 示例 1：

// 输入：[1,2,5,9,5,9,5,5,5]
// 输出：5
// 示例 2：

// 输入：[3,2]
// 输出：-1
// 示例 3：

// 输入：[2,2,1,1,1,2,2]
// 输出：2
class Solution_331 {
    public int majorityElement(int[] nums) {
        int candidate = -1, vote = 0;
        for (int num : nums) {
            if (vote == 0) {
                candidate = num;
                vote = 1;
            } else {
                vote += candidate == num ? 1 : -1;
            }
        }
        vote = 0;
        for (int num : nums) {
            if (candidate == num) {
                vote++;
            }
        }
        return vote > nums.length / 2 ? candidate : -1;
    }

    public static void main(String args[]) {
        Solution_331 solution = new Solution_331();
        int[] nums_1 = { 1, 2, 5, 9, 5, 9, 5, 5, 5 }, nums_2 = { 3, 2 }, nums_3 = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(solution.majorityElement(nums_1));
        System.out.println(solution.majorityElement(nums_2));
        System.out.println(solution.majorityElement(nums_3));
    }
}