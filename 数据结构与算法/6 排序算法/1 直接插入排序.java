class Solution {
    /**
     * 直接插入排序
     * @param nums 待排序数组
     */
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
}