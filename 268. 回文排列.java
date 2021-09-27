// 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。

// 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。

// 回文串不一定是字典当中的单词。

//  

// 示例1：

// 输入："tactcoa"
// 输出：true（排列有"tacocat"、"atcocta"，等等）
class Solution_268 {
    public boolean canPermutePalindrome(String s) {
        int[] set = new int[128];
        int count = 0;
        for (char ch : s.toCharArray()) {
            if ((set[ch]++ & 1) == 1) {
                count++;
            } else {
                count--;
            }
        }
        return count <= 1;
    }

    public static void main(String args[]) {
        Solution_268 solution = new Solution_268();
        String s_1 = "tactcoa";
        System.out.println(solution.canPermutePalindrome(s_1));
    }
}