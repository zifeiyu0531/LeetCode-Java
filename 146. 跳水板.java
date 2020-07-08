import java.util.*;

// 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。

// 返回的长度需要从小到大排列。

// 示例：

// 输入：
// shorter = 1
// longer = 2
// k = 3
// 输出： {3,4,5,6}
// 提示：

// 0 < shorter <= longer
// 0 <= k <= 100000

class Solution_146 {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k <= 0) {
            return new int[0];
        }
        int[] ans = new int[k + 2];
        int num_s = k, num_l = 0;
        int index = 1;
        ans[0] = 0;
        while (num_s >= 0) {
            int len = num_s * shorter + num_l * longer;
            if (len > ans[index - 1]) {
                ans[index] = len;
                index++;
            }
            num_s--;
            num_l++;
        }
        return Arrays.copyOfRange(ans, 1, index);
    }

    public static void main(String args[]) {
        Solution_146 solution = new Solution_146();
        int shorter = 1;
        int longer = 2;
        int k = 3;
        System.out.println(Arrays.toString(solution.divingBoard(shorter, longer, k)));
    }
}