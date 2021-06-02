import java.util.*;
// 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

//  

// 示例 1：

// 输入：target = 9
// 输出：[[2,3,4],[4,5]]
// 示例 2：

// 输入：target = 15
// 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
//  

// 限制：

// 1 <= target <= 10^5
class Solution_234 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        for (int l = 1, r = 2; l < r;) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum == target) {
                int[] temp = new int[r - l + 1];
                for (int i = l; i <= r; i++) {
                    temp[i - l] = i;
                }
                res.add(temp);
                l++;
            } else if (sum < target) {
                r++;
            } else {
                l++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String args[]) {
        Solution_234 solution = new Solution_234();
        int target_1 = 9, target_2 = 15;
        System.out.println(Arrays.toString(solution.findContinuousSequence(target_1)));
        System.out.println(Arrays.toString(solution.findContinuousSequence(target_2)));
    }
}