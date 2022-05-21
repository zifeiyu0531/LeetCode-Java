package 牛客TOP100;

class Solution {
    public String trans(String s, int n) {
        int right = 0;
        String res = "";
        while (right < n) {
            String subStr = "";
            while (right < n && s.charAt(right) != ' ') {
                char ch = s.charAt(right++);
                if (ch >= 'a' && ch <= 'z') {
                    subStr += (char) (ch - ('a' - 'A'));
                } else {
                    subStr += (char) (ch + ('a' - 'A'));
                }
            }
            res = subStr + res;
            while (right < n && s.charAt(right) == ' ') {
                res = ' ' + res;
                right++;
            }
        }
        return res;
    }
}