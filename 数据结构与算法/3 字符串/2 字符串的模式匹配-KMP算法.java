class Solution_2 {
    /**
     * 现有目标串s与模式串t，要求返回s中与t相同的子串起始下标位置，若没有，返回-1
     * 
     * @param s 目标串
     * @param t 模式串
     * @return s中与t相同的字串起始下标位置
     */
    public int KMP(String s, String t) {
        int[] next = new int[t.length()];
        getNext(t, next);
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (j == -1 || s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j >= t.length()) {
            return i - t.length();
        } else {
            return -1;
        }
    }

    private void getNext(String t, int[] next) {
        int j = 0, k = -1;
        next[0] = -1;
        while (j < t.length() - 1) {
            if (k == -1 || t.charAt(j) == t.charAt(k)) {
                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
    }
}