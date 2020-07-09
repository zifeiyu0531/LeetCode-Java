class Solution_3 {
    /**
     * 验证字符串是否为回文串
     * 
     * @param str 待验证的字符串
     * @return 是回文串返回true,否则返回false
     */
    public boolean isPalindrome(String str) {
        MyStack<Character> stack = new MyStack<Character>();
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }
        for (char ch : str.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}