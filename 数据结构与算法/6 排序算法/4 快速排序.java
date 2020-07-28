class Solution_4 {
    /**
     * 快速排序
     * 
     * @param nums  待排序数组
     * @param left  待排序区间最左侧
     * @param right 待排序区间最右侧
     */
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
}