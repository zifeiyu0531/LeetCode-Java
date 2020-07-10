class Solution_1 {
    /**
     * 现有目标串s与模式串t，要求返回s中与t相同的字串起始下标位置，若没有，返回-1
     * 
     * @param s 目标串
     * @param t 模式串
     * @return s中与t相同的字串起始下标位置
     */
    public int bruteForce(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j >= t.length()) {
            return i - t.length();
        } else {
            return -1;
        }
    }
}