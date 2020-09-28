import java.util.*;

// 所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。

// 编写一个函数来查找目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。

//  

// 示例：

// 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
// 输出：["AAAAACCCCC", "CCCCCAAAAA"]

class Solution_172 {
    public List<String> findRepeatedDnaSequences(String s) {
        int L = 10;
        HashSet<String> seen = new HashSet<String>();
        HashSet<String> out = new HashSet<String>();

        for (int i = 0; i < s.length() - L + 1; i++) {
            String subStr = s.substring(i, i + L);
            if (seen.contains(subStr)) {
                out.add(subStr);
            } else {
                seen.add(subStr);
            }
        }

        return new ArrayList<String>(out);
    }

    public static void main(String args[]) {
        Solution_172 solution = new Solution_172();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(solution.findRepeatedDnaSequences(s).toString());
    }
}