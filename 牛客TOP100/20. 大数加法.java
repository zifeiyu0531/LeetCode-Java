package 牛客TOP100;

class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     * 
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve(String s, String t) {
        StringBuilder res = new StringBuilder();
        int idx1 = s.length() - 1, idx2 = t.length() - 1;
        int carry = 0;
        while (idx1 >= 0 || idx2 >= 0) {
            int num1 = 0, num2 = 0;
            if (idx1 >= 0) {
                num1 = s.charAt(idx1) - '0';
            }
            if (idx2 >= 0) {
                num2 = t.charAt(idx2) - '0';
            }
            int sum = num1 + num2 + carry;
            int remain = sum % 10;
            carry = sum / 10;
            res.append(remain);
            idx1--;
            idx2--;
        }
        if (carry > 0) {
            res.append(carry);
        }
        return res.reverse().toString();
    }
}