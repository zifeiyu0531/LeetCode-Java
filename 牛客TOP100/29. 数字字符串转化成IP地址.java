package 牛客TOP100;

import java.util.*;

class Solution {
    /**
     * 
     * @param s string字符串
     * @return string字符串ArrayList
     */
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        this.dfs(s, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(String s, List<String> res, List<String> temp, int start) {
        if (temp.size() != 4 && start >= s.length()) {
            return;
        }
        if (temp.size() == 4) {
            this.encode(res, temp, s);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length()) {
                break;
            }
            String subStr = s.substring(start, start + i);
            if (Integer.valueOf(subStr) > 255 || (i > 1 && s.charAt(start) == '0')) {
                break;
            }
            temp.add(subStr);
            start += i;
            dfs(s, res, temp, start);
            start -= i;
            temp.remove(temp.size() - 1);
        }
    }

    private void encode(List<String> res, List<String> temp, String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; i < 3; i++) {
            sb.append(temp.get(i) + ".");
        }
        sb.append(temp.get(i));
        if (sb.length() == s.length() + 3) {
            res.add(sb.toString());
        }
    }
}