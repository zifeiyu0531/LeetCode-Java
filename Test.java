import java.util.*;

class Solution {
    void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                int temp = nums[i];
                int j = i - 1;
                while (j >= 0 && nums[j] > temp) {
                    nums[j + 1] = nums[j];
                    j--;
                }
                nums[j + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 7, 3, 6, 5, 2, 0, 8 };
        solution.insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}