// 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

// 示例 1:

// 输入: num1 = "2", num2 = "3"
// 输出: "6"
// 示例 2:

// 输入: num1 = "123", num2 = "456"
// 输出: "56088"
// 说明：

// num1 和 num2 的长度小于110。
// num1 和 num2 只包含数字 0-9。
// num1 和 num2 均不以零开头，除非是数字 0 本身。
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

class Solution_67 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) {
            String temp_1 = num1.substring(i, i + 1);
            int carry = 0;
            StringBuilder sb_temp = new StringBuilder();
            for (int j = num2.length() - 1; j >= 0; j--) {
                String temp_2 = num2.substring(j, j + 1);
                int temp = Integer.parseInt(temp_1) * Integer.parseInt(temp_2) + carry;
                carry = temp / 10;
                sb_temp.insert(0, temp % 10);
            }
            if (carry != 0) {
                sb_temp.insert(0, carry);
            }
            sb = sbAdd(sb, sb_temp, num1.length() - 1 - i);
        }
        return sb.toString();
    }

    public StringBuilder sbAdd(StringBuilder sb, StringBuilder sb_temp, int offset) {
        for (int i = 0; i < offset; i++) {
            sb_temp.append('0');
        }
        int i = sb.length() - 1, j = sb_temp.length() - 1;
        int carry = 0;
        int add = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                add = Integer.parseInt(sb_temp.substring(j, j + 1)) + carry;
            } else if (j < 0) {
                add = Integer.parseInt(sb.substring(i, i + 1)) + carry;
            } else {
                add = Integer.parseInt(sb.substring(i, i + 1)) + Integer.parseInt(sb_temp.substring(j, j + 1)) + carry;
            }
            carry = add / 10;
            res.insert(0, add % 10);
            i--;
            j--;
        }
        if (carry != 0) {
            res.insert(0, carry);
        }
        return res;
    }

    public static void main(String args[]) {
        Solution_67 solution = new Solution_67();
        String num1_1 = "2", num1_2 = "123";
        String num2_1 = "3", num2_2 = "456";
        System.out.println(solution.multiply(num1_1, num2_1));
        System.out.println(solution.multiply(num1_2, num2_2));
    }
}