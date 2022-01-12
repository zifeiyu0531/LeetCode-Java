import java.util.*;

// 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。

// 示例 1:

// 输入: temperatures = [73,74,75,71,69,72,76,73]
// 输出: [1,1,4,2,1,1,0,0]
// 示例 2:

// 输入: temperatures = [30,40,50,60]
// 输出: [1,1,1,0]
// 示例 3:

// 输入: temperatures = [30,60,90]
// 输出: [1,1,0]
//  

// 提示：

// 1 <= temperatures.length <= 105
// 30 <= temperatures[i] <= 100
class Solution_364 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty() || temperatures[stack.peek()] >= temperatures[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    int idx = stack.pop();
                    res[idx] = i - idx;
                }
                stack.push(i);
            }
        }
        return res;
    }

    public static void main(String args[]) {
        Solution_364 solution = new Solution_364();
        int[] temperatures_1 = { 73, 74, 75, 71, 69, 72, 76, 73 }, temperatures_2 = { 30, 40, 50, 60 },
                temperatures_3 = { 30, 60, 90 };
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures_1)));
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures_2)));
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures_3)));
    }
}