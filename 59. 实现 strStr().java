// 实现 strStr() 函数。

// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

// 示例 1:

// 输入: haystack = "hello", needle = "ll"
// 输出: 2
// 示例 2:

// 输入: haystack = "aaaaa", needle = "bba"
// 输出: -1
// 说明:

// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

class Solution_59 {
    public int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        for (i = 0; i < haystack.length() && j < needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                continue;
            }
            i -= j;
            j = 0;
        }
        if (j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static void main(String args[]) {
        Solution_59 solution = new Solution_59();
        String haystack_1 = "mississippi", haystack_2 = "aaaaa";
        String needle_1 = "issip", needle_2 = "bba";
        System.out.println(solution.strStr(haystack_1, needle_1));
        System.out.println(solution.strStr(haystack_2, needle_2));
    }
}