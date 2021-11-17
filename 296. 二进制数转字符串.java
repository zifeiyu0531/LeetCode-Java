// 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”。

// 示例1:

//  输入：0.625
//  输出："0.101"
// 示例2:

//  输入：0.1
//  输出："ERROR"
//  提示：0.1无法被二进制准确表示
// 提示：

// 32位包括输出中的"0."这两位。
class Solution_296 {
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        while (num > 0) {
            num *= 2;
            if (num >= 1) {
                sb.append("1");
                num -= 1;
            } else {
                sb.append("0");
            }
            if (sb.length() > 32) {
                return "ERROR";
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        Solution_296 solution = new Solution_296();
        double num_1 = 0.625, num_2 = 0.1;
        System.out.println(solution.printBin(num_1));
        System.out.println(solution.printBin(num_2));
    }
}