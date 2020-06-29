import java.util.*;

// 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

// 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。

//  

// 示例:

// 输入: "25525511135"
// 输出: ["255.255.11.135", "255.255.111.35"]

class Solution_106 {
    List<String> ans;

    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<String>();
        backTrace(s, 0, new ArrayDeque<String>());
        return ans;
    }

    public void backTrace(String s, int start, Deque<String> s_list) {
        if (s_list.size() == 4) {
            if (start == s.length()) {
                Deque<String> list_temp = new ArrayDeque<String>(s_list);
                String str = getIp(list_temp);
                ans.add(str);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String temp = s.substring(start, i + 1);
            int num = Integer.parseInt(temp);
            if (num > 255) {
                break;
            }
            s_list.addLast(temp);
            backTrace(s, i + 1, s_list);
            s_list.removeLast();
            if (num == 0) {
                break;
            }
        }
    }

    public String getIp(Deque<String> s_list) {
        String ip = "";
        while (s_list.size() > 1) {
            ip += s_list.poll();
            ip += ".";
        }
        ip += s_list.poll();
        return ip;
    }

    public static void main(String args[]) {
        Solution_106 solution = new Solution_106();
        String s = "25525511135";
        System.out.println(solution.restoreIpAddresses(s).toString());
    }
}