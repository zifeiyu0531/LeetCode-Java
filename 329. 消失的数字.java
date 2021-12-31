// 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？

// 注意：本题相对书上原题稍作改动

// 示例 1：

// 输入：[3,0,1]
// 输出：2
//  

// 示例 2：

// 输入：[9,6,4,2,3,5,7,0,1]
// 输出：8
class Solution_329 {
    public int missingNumber(int[] nums) {
        // 0和任何值的异或等于本身，即：A ^ 0 = A
        // 异或本身等于0，即 A ^ A = 0
        // 异或满足结合律，即 A ^ B ^ C = A ^ ( B ^ C)
        // res = res ^ x ^ x。对同一个值异或两次，那么结果等于它本身
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }
        res ^= nums.length;
        return res;
    }

    public static void main(String args[]) {
        Solution_329 solution = new Solution_329();
        int[] nums_1 = { 3, 0, 1 }, nums_2 = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        System.out.println(solution.missingNumber(nums_1));
        System.out.println(solution.missingNumber(nums_2));
    }
}