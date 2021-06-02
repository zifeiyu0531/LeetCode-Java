import java.util.*;

// 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

// 示例:

// s = "abaccdeff"
// 返回 "b"

// s = "" 
// 返回 " "
//  

// 限制：

// 0 <= s 的长度 <= 50000
class Solution_226 {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public static void main(String args[]) {
        Solution_226 solution = new Solution_226();
        String s_1 = "abaccdeff", s_2 = "";
        System.out.println(solution.firstUniqChar(s_1));
        System.out.println(solution.firstUniqChar(s_2));
    }
}