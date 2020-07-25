import java.util.*;

class Solution {
    void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 7, 3, 6, 5, 2, 0, 8 };
        solution.bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}