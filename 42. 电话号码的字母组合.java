import java.util.*;

// 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

// 示例:

// 输入："23"
// 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 说明:
// 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

class Solution_42 {
    Map<Character, String> map = new HashMap<Character, String>() {
        private static final long serialVersionUID = 1L;
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");

        }
    };
    List<String> str_list = new ArrayList<String>();

    public void backtrack(String combine, String sub_digits) {
        if (sub_digits.length() == 0) {
            str_list.add(combine);
        } else {
            char ch = sub_digits.charAt(0);
            for (int i = 0; i < map.get(ch).length(); i++) {
                backtrack(combine + map.get(ch).substring(i, i + 1), sub_digits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() > 0) {
            backtrack("", digits);
        }
        return str_list;
    }

    public static void main(String args[]) {
        Solution_42 solution = new Solution_42();
        String digits_1 = "23";
        System.out.println(solution.letterCombinations(digits_1).toString());
    }
}