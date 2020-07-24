class MySearch {
    /**
     * 折半查找
     * 
     * @param nums 有序数组nums
     * @param key  目标值key
     * @return key在nums中的位置（不存在返回-1）
     */
    public int BinarySearch(int[] nums, int key) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MySearch solution = new MySearch();
        int[] nums = { 1, 2, 5, 8, 9, 11, 12, 15 };
        int key_1 = 12, key_2 = 10;
        System.out.println(solution.BinarySearch(nums, key_1));
        System.out.println(solution.BinarySearch(nums, key_2));
    }
}