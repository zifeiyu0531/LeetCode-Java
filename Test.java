import java.util.*;

class Solution {
    public void quickSort(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }
        int key = nums[leftIndex];
        int left = leftIndex, right = rightIndex;
        while (left < right) {
            while (left < right && nums[right] >= key) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= key) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = key;
        quickSort(nums, leftIndex, left - 1);
        quickSort(nums, right + 1, rightIndex);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 7, 3, 6, 5, 2, 0, 8 };
        solution.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}