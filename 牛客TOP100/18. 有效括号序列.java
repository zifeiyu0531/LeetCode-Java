package 牛客TOP100;

import java.util.*;

class Solution {
    /**
     * 
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != map.get(ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }
}