// 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。

// 示例 1：

// 输入： pattern = "abba", value = "dogcatcatdog"
// 输出： true
// 示例 2：

// 输入： pattern = "abba", value = "dogcatcatfish"
// 输出： false
// 示例 3：

// 输入： pattern = "aaaa", value = "dogcatcatdog"
// 输出： false
// 示例 4：

// 输入： pattern = "abba", value = "dogdogdogdog"
// 输出： true
// 解释： "a"="dogdog",b=""，反之也符合规则
// 提示：

// 0 <= len(pattern) <= 1000
// 0 <= len(value) <= 1000
// 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。

class Solution_31 {
    public boolean patternMatching(String pattern, String value) {
        int count_a = 0, count_b = 0;
        char[] ch_array = pattern.toCharArray();
        for (char ch : ch_array) {
            if (ch == 'a') {
                count_a++;
            } else {
                count_b++;
            }
        }
        if (count_a < count_b) {
            int temp = count_a;
            count_a = count_b;
            count_b = temp;
            for (int i = 0; i < pattern.length(); i++) {
                ch_array[i] = (ch_array[i] == 'a' ? 'b' : 'a');
            }
        }
        if (value.length() == 0) {
            return count_b == 0;
        }
        if (pattern.length() == 0) {
            return false;
        }
        for (int len_a = 0; len_a * count_a <= value.length(); len_a++) {
            int rest = value.length() - len_a * count_a;
            if ((count_b == 0 && rest == 0) || (count_b != 0 && rest % count_b == 0)) {
                int len_b = (count_b == 0 ? 0 : rest / count_b);
                boolean correct = true;
                int index = 0;
                String value_a = "", value_b = "";
                for (char ch : ch_array) {
                    if (ch == 'a') {
                        String sub = value.substring(index, index + len_a);
                        if (value_a.length() == 0) {
                            value_a = sub;
                        } else if (!value_a.equals(sub)) {
                            correct = false;
                            break;
                        }
                        index += len_a;
                    } else {
                        String sub = value.substring(index, index + len_b);
                        if (value_b.length() == 0) {
                            value_b = sub;
                        } else if (!value_b.equals(sub)) {
                            correct = false;
                            break;
                        }
                        index += len_b;
                    }
                }
                if (correct && !value_a.equals(value_b)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Solution_31 solution = new Solution_31();
        String pattern_1 = "abba", pattern_2 = "abba", pattern_3 = "aaaa";
        String value_1 = "dogcatcatdog", value_2 = "dogcatcatfish", value_3 = "dogcatcatdog";
        System.out.println(solution.patternMatching(pattern_1, value_1));
        System.out.println(solution.patternMatching(pattern_2, value_2));
        System.out.println(solution.patternMatching(pattern_3, value_3));
    }
}