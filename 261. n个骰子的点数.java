import java.util.*;

// 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。

//  

// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。

//  

// 示例 1:

// 输入: 1
// 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
// 示例 2:

// 输入: 2
// 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
//  

// 限制：

// 1 <= n <= 11
class Solution_261 {
    public double[] dicesProbability(int n) {
        int[] counts = new int[] { 1, 1, 1, 1, 1, 1 };
        for (int i = 1; i < n; i++) {
            int[] temp = new int[counts.length + 6];
            for (int j = i - 1; j < counts.length; j++) {
                for (int k = 1; k <= 6; k++) {
                    temp[j + k] += counts[j];
                }
            }
            counts = temp;
        }
        double sum = Math.pow(6, n);
        double[] res = new double[counts.length - n + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = counts[i + n - 1] / sum;
        }
        return res;
    }

    public static void main(String args[]) {
        Solution_261 solution = new Solution_261();
        int n_1 = 1, n_2 = 2;
        System.out.println(Arrays.toString(solution.dicesProbability(n_1)));
        System.out.println(Arrays.toString(solution.dicesProbability(n_2)));
    }
}