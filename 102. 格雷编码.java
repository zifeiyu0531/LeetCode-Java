import java.util.*;

// 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。

// 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。

// 格雷编码序列必须以 0 开头。

//  

// 示例 1:

// 输入: 2
// 输出: [0,1,3,2]
// 解释:
// 00 - 0
// 01 - 1
// 11 - 3
// 10 - 2

// 对于给定的 n，其格雷编码序列并不唯一。
// 例如，[0,2,3,1] 也是一个有效的格雷编码序列。

// 00 - 0
// 10 - 2
// 11 - 3
// 01 - 1
// 示例 2:

// 输入: 0
// 输出: [0]
// 解释: 我们定义格雷编码序列必须以 0 开头。
//      给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
//      因此，当 n = 0 时，其格雷编码序列为 [0]。

class Solution_102 {
    List<Integer> ans;

    public List<Integer> grayCode(int n) {
        ans = new ArrayList<Integer>();
        if (n == 0) {
            ans.add(0);
        } else {
            backTrace(n, new StringBuilder(), false);
        }
        return ans;
    }

    public void backTrace(int n, StringBuilder sb, boolean opposite) {
        if (sb.length() == n) {
            String str = sb.toString();
            ans.add(Integer.parseInt(str, 2));
            return;
        }
        if (!opposite) {
            sb.append('0');
            backTrace(n, sb, false);
            sb.deleteCharAt(sb.length() - 1);
            sb.append('1');
            backTrace(n, sb, true);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append('1');
            backTrace(n, sb, false);
            sb.deleteCharAt(sb.length() - 1);
            sb.append('0');
            backTrace(n, sb, true);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String args[]) {
        Solution_102 solution = new Solution_102();
        int n_1 = 2, n_2 = 0;
        System.out.println(solution.grayCode(n_1).toString());
        System.out.println(solution.grayCode(n_2).toString());
    }
}