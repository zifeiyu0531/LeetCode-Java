import java.util.*;

// 给定两个字符串 s 和 t，判断它们是否是同构的。

// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。

// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

// 示例 1:

// 输入: s = "egg", t = "add"
// 输出: true
// 示例 2:

// 输入: s = "foo", t = "bar"
// 输出: false
// 示例 3:

// 输入: s = "paper", t = "title"
// 输出: true
// 说明:
// 你可以假设 s 和 t 具有相同的长度。

class Solution_183 {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            char value = t.charAt(i);
            if (!map.containsKey(key)) {
                if (map.containsValue(value)) {
                    return false;
                }
                map.put(key, value);
            } else if (map.get(key) != value) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Solution_183 solution = new Solution_183();
        String s_1 = "egg", s_2 = "foo", s_3 = "paper";
        String t_1 = "add", t_2 = "bar", t_3 = "title";
        System.out.println(solution.isIsomorphic(s_1, t_1));
        System.out.println(solution.isIsomorphic(s_2, t_2));
        System.out.println(solution.isIsomorphic(s_3, t_3));
    }
}