import java.util.*;

// 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。

//  

// 示例 1:

// 输入: nums = [1,1,1,2,2,3], k = 2
// 输出: [1,2]
// 示例 2:

// 输入: nums = [1], k = 1
// 输出: [1]
//  

// 提示：

// 1 <= nums.length <= 105
// k 的取值范围是 [1, 数组中不相同的元素的个数]
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
//  

// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution_350 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer[]> heap = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] a, Integer[] b) {
                return a[1] - b[1];
            }
        });
        for (int key : map.keySet()) {
            if (heap.size() < k) {
                heap.offer(new Integer[] { key, map.get(key) });
                continue;
            }
            if (map.get(key) > heap.peek()[1]) {
                heap.poll();
                heap.offer(new Integer[] { key, map.get(key) });
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[0];
        }
        return res;
    }

    public static void main(String args[]) {
        Solution_350 solution = new Solution_350();
        int[] nums_1 = { 1, 1, 1, 2, 2, 3 }, nums_2 = { 1 };
        int k_1 = 2, k_2 = 1;
        System.out.println(Arrays.toString(solution.topKFrequent(nums_1, k_1)));
        System.out.println(Arrays.toString(solution.topKFrequent(nums_2, k_2)));
    }
}