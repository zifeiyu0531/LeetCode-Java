import java.util.*;

// 给出一个区间的集合，请合并所有重叠的区间。

// 示例 1:

// 输入: [[1,3],[2,6],[8,10],[15,18]]
// 输出: [[1,6],[8,10],[15,18]]
// 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 示例 2:

// 输入: [[1,4],[4,5]]
// 输出: [[1,5]]
// 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

class Solution_76 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Deque<int[]> list = new ArrayDeque<int[]>();
        int right = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (i == 0) {
                list.add(intervals[0]);
                right = intervals[0][1];
            } else {
                if (intervals[i][0] <= right) {
                    right = Math.max(right, intervals[i][1]);
                    list.getLast()[1] = right;
                    continue;
                } else {
                    list.add(intervals[i]);
                    right = intervals[i][1];
                }
            }
        }
        return list.toArray(new int[0][]);
    }

    public static void main(String args[]) {
        Solution_76 solution = new Solution_76();
        int[][] intervals_1 = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } }, intervals_2 = { { 1, 4 }, { 4, 5 } };
        System.out.println(Arrays.deepToString(solution.merge(intervals_1)));
        System.out.println(Arrays.deepToString(solution.merge(intervals_2)));
    }
}