// 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。

//  

// 示例 1:

// 输入: [3,2,3]
// 输出: 3
// 示例 2:

// 输入: [2,2,1,1,1,2,2]
// 输出: 2

class Solution_167 {
    public int majorityElement(int[] nums) {
        int candidate = -1, count = 0;
        for (int i : nums) {
            if (count == 0) {
                candidate = i;
            }
            if (candidate == i) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static void main(String args[]) {
        Solution_167 solution = new Solution_167();
        int[] nums_1 = { 3, 2, 3 }, nums_2 = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(solution.majorityElement(nums_1));
        System.out.println(solution.majorityElement(nums_2));
    }
}