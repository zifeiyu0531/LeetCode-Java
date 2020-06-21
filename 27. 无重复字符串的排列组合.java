import java.util.*;

// 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。

// 示例1:

//  输入：S = "qwe"
//  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
// 示例2:

//  输入：S = "ab"
//  输出：["ab", "ba"]
// 提示:

// 字符都是英文字母。
// 字符串长度在[1, 9]之间。

class Solution_27 {
    public String[] permutation(String S) {
        ArrayList<String> str_array = new ArrayList<String>();
        str_array.add("");
        for (int i = 0; i < S.length(); i++) {
            ArrayList<String> temp_array = new ArrayList<String>();
            for (int j = 0; j < str_array.size(); j++) {
                String temp_str = str_array.get(j);
                for (int k = 0; k <= temp_str.length(); k++) {
                    StringBuilder temp_strb = new StringBuilder(temp_str);
                    temp_array.add(temp_strb.insert(k, S.charAt(i)).toString());
                }
            }
            str_array = temp_array;
        }
        return (String[]) str_array.toArray(new String[0]);
    }

    public static void main(String args[]) {
        Solution_27 solution = new Solution_27();
        String S_1 = "qwe", S_2 = "ab";
        System.out.println(Arrays.toString(solution.permutation(S_1)));
        System.out.println(Arrays.toString(solution.permutation(S_2)));
    }
}