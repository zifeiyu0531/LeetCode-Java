import java.util.*;

class Solution {

    private int partition(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= temp) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= temp) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int index = partition(nums, left, right);
            quickSort(nums, left, index - 1);
            quickSort(nums, index + 1, right);
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] nums = { 3, 1 };
        solution.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        // System.out.println(solution.permuteUnique(num).toString());
    }
}