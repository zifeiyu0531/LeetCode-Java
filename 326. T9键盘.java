import java.util.*;

// 在老式手机上，用户通过数字键盘输入，手机将提供与这些数字相匹配的单词列表。每个数字映射到0至4个字母。给定一个数字序列，实现一个算法来返回匹配单词的列表。你会得到一张含有有效单词的列表。映射如下图所示：

// 示例 1:

// 输入: num = "8733", words = ["tree", "used"]
// 输出: ["tree", "used"]
// 示例 2:

// 输入: num = "2", words = ["a", "b", "c", "d"]
// 输出: ["a", "b", "c"]
// 提示：

// num.length <= 1000
// words.length <= 500
// words[i].length == num.length
// num中不会出现 0, 1 这两个数字
class Solution_326 {
    public List<String> getValidT9Words(String num, String[] words) {
        if (num.length() <= 0) {
            return new ArrayList<>();
        }
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        Trie trie = new Trie(map);
        trie.insert(num);
        List<String> res = new ArrayList<>();
        for (String str : words) {
            if (trie.searchPrefix(str) != null) {
                res.add(str);
            }
        }
        return res;
    }

    private class Trie {
        private Map<Integer, String> map;
        private Trie[] children;

        public Trie(Map<Integer, String> map) {
            this.map = map;
            this.children = new Trie[26];
        }

        public Trie() {
            this.children = new Trie[26];
        }

        public void insert(String num) {
            Trie node = this;
            for (char num_ch : num.toCharArray()) {
                int idx = num_ch - '0';
                String str = this.map.get(idx);
                Trie t = new Trie();
                for (char ch : str.toCharArray()) {
                    int child_idx = ch - 'a';
                    if (node.children[child_idx] == null) {
                        node.children[child_idx] = t;
                    }
                }
                node = t;
            }
        }

        public Trie searchPrefix(String str) {
            Trie t = this;
            for (char ch : str.toCharArray()) {
                int idx = ch - 'a';
                if (t.children[idx] == null) {
                    return null;
                }
                t = t.children[idx];
            }
            return t;
        }
    }

    public static void main(String args[]) {
        Solution_326 solution = new Solution_326();
        String num_1 = "8733", num_2 = "2";
        String[] words_1 = { "tree", "used" }, words_2 = { "a", "b", "c", "d" };
        System.out.println(solution.getValidT9Words(num_1, words_1).toString());
        System.out.println(solution.getValidT9Words(num_2, words_2).toString());
    }
}