import java.util.*;

class Solution {
    void binaryInsertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                int temp = nums[i];
                int left = 0, right = i - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (temp > nums[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                for (int j = i - 1; j > right; j--) {
                    nums[j + 1] = nums[j];
                }
                nums[right + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 7, 3, 6, 5, 2, 0, 8 };
        solution.binaryInsertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}