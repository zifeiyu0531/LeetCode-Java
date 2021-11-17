// 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。

// 示例 1：

// 输入: num = 1775(110111011112)
// 输出: 8
// 示例 2：

// 输入: num = 7(01112)
// 输出: 4
class Solution_297 {
    public int reverseBits(int num) {
        int curr = 0;
        int res = 0;
        int insert = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) != 0) {
                curr++;
                insert++;
            } else {
                insert = curr + 1;
                curr = 0;
            }
            res = Math.max(res, insert);
        }
        return res;
    }

    public static void main(String args[]) {
        Solution_297 solution = new Solution_297();
        int num_1 = 1775, num_2 = 7;
        System.out.println(solution.reverseBits(num_1));
        System.out.println(solution.reverseBits(num_2));
    }
}