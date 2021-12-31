// 有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?

// 示例：

// 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
// 输出：1
// 提示：

// words.length <= 100000
class Solution_332 {
    public int findClosest(String[] words, String word1, String word2) {
        int position1 = -1, position2 = -1;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                int newDistance = (position2 != -1) ? (i - position2) : distance;
                distance = Math.min(distance, newDistance);
                position1 = i;
            }
            if (word.equals(word2)) {
                int newDistance = (position1 != -1) ? (i - position1) : distance;
                distance = Math.min(distance, newDistance);
                position2 = i;
            }
        }
        return distance;
    }

    public static void main(String args[]) {
        Solution_332 solution = new Solution_332();
        String[] words = { "I", "am", "a", "student", "from", "a", "university", "in", "a", "city" };
        String word1 = "a";
        String word2 = "student";
        System.out.println(solution.findClosest(words, word1, word2));
    }
}