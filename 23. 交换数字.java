import java.util.Arrays;

// 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。

// 示例：

// 输入: numbers = [1,2]
// 输出: [2,1]
// 提示：

// numbers.length == 2

class Solution_23 {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] + numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] = numbers[0] - numbers[1];
        return numbers;
    }

    public static void main(String args[]) {
        Solution_23 solution = new Solution_23();
        int[] numbers = { 1, 2 };
        System.out.println(Arrays.toString(solution.swapNumbers(numbers)));
    }
}