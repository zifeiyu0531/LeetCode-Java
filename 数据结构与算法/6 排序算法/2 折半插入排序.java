class Solution_2 {
    /**
     * 折半插入排序
     * 
     * @param nums 待排序数组
     */
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
}