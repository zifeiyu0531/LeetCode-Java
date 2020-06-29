// 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

// 示例 1:

// 输入: [3,2,1,5,6,4] 和 k = 2
// 输出: 5
// 示例 2:

// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
// 输出: 4
// 说明:

// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。

class Solution_101 {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums);
        for (int i = nums.length - 1; i > nums.length - k; i--) {
            swap(nums, i, 0);
            heapSize--;
            sift(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] nums) {
        int heapSize = nums.length;
        for (int i = heapSize / 2; i >= 0; i--) {
            sift(nums, i, heapSize);
        }
    }

    public void sift(int[] nums, int i, int heapSize) {
        int left = i * 2, right = i * 2 + 1, large = i;
        if (left < heapSize && nums[left] > nums[large]) {
            large = left;
        }
        if (right < heapSize && nums[right] > nums[large]) {
            large = right;
        }
        if (i != large) {
            swap(nums, i, large);
            sift(nums, large, heapSize);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String args[]) {
        Solution_101 solution = new Solution_101();
        int[] nums_1 = { 3, 2, 1, 5, 6, 4 }, nums_2 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k_1 = 2, k_2 = 4;
        System.out.println(solution.findKthLargest(nums_1, k_1));
        System.out.println(solution.findKthLargest(nums_2, k_2));
    }
}