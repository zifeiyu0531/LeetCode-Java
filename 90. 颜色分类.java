import java.util.Arrays;

// 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

// 注意:
// 不能使用代码库中的排序函数来解决这道题。

// 示例:

// 输入: [2,0,2,1,1,0]
// 输出: [0,0,1,1,2,2]
// 进阶：

// 一个直观的解决方案是使用计数排序的两趟扫描算法。
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
// 你能想出一个仅使用常数空间的一趟扫描算法吗？

class Solution_90 {
    public void sortColors(int[] nums) {
        QuickSort(nums, 0, nums.length - 1);
    }

    public void QuickSort(int[] nums, int left, int right) {
        if (left < right) {
            int i = left, j = right;
            int temp = nums[i];
            while (i < j) {
                while (i < j && nums[j] >= temp) {
                    j--;
                }
                nums[i] = nums[j];
                while (i < j && nums[i] <= temp) {
                    i++;
                }
                nums[j] = nums[i];
            }
            nums[i] = temp;
            QuickSort(nums, left, i - 1);
            QuickSort(nums, i + 1, right);
        }
    }

    public static void main(String args[]) {
        Solution_90 solution = new Solution_90();
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}