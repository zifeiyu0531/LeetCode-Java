import java.util.*;

// 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

// 示例 1:

// 输入: [10,2]
// 输出: 210
// 示例 2:

// 输入: [3,30,34,5,9]
// 输出: 9534330
// 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。

class Solution_171 {

    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            String order1 = str1 + str2;
            String order2 = str2 + str1;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        String[] nums_str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums_str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(nums_str, new LargerNumberComparator());

        if (nums_str[0].equals("0")) {
            return "0";
        }

        String s = "";
        for (String str : nums_str) {
            s += str;
        }
        return s;
    }

    public static void main(String args[]) {
        Solution_171 solution = new Solution_171();
        int[] nums_1 = { 10, 2 }, nums_2 = { 3, 30, 34, 5, 9 };
        System.out.println(solution.largestNumber(nums_1));
        System.out.println(solution.largestNumber(nums_2));
    }
}