// 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。

// 说明：

// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

// 示例 1:

// 输入: [2,2,3,2]
// 输出: 3
// 示例 2:

// 输入: [0,1,0,1,0,1,99]
// 输出: 99

class Solution_143 {
    public int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;
        for (int num : nums) {
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }
        return seenOnce;
    }

    public static void main(String args[]) {
        Solution_143 solution = new Solution_143();
        int[] nums_1 = { 2, 2, 3, 2 }, nums_2 = { 0, 1, 0, 1, 0, 1, 99 };
        System.out.println(solution.singleNumber(nums_1));
        System.out.println(solution.singleNumber(nums_2));
    }
}