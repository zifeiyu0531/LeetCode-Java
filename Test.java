import java.util.*;

class Solution {
    public void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 7, 3, 6, 5, 2, 0, 8 };
        solution.selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}