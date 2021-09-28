import java.util.*;

// 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。

//  

// 示例 1:

// 输入: 
// first = "pale"
// second = "ple"
// 输出: True
//  

// 示例 2:

// 输入: 
// first = "pales"
// second = "pal"
// 输出: False
class Solution_269 {
    public boolean oneEditAway(String first, String second) {
        int m = first.length(), n = second.length();
        if (Math.abs(m - n) > 1) {
            return false;
        }
        boolean match = true;
        for (int i = 0, j = 0; i < m && j < n;) {
            if (first.charAt(i++) == second.charAt(j++)) {
                continue;
            }
            if (!match) {
                return false;
            }
            match = false;
            if (m > n) {
                j--;
            }
            if (m < n) {
                i--;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Solution_269 solution = new Solution_269();
        String first_1 = "pale", first_2 = "pales";
        String second_1 = "ple", second_2 = "pal";
        System.out.println(solution.oneEditAway(first_1, second_1));
        System.out.println(solution.oneEditAway(first_2, second_2));
    }
}