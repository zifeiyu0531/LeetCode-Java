// 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。

// 示例1:

//  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
//  输出：-1
//  说明: 不存在返回-1。
// 示例2:

//  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
//  输出：4
// 提示:

// words的长度在[1, 1000000]之间
class Solution_314 {
    public int findString(String[] words, String s) {
        int left = 0, right = words.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            while (left < mid && words[mid].equals("")) {
                mid--;
            }
            if (words[mid].equals(s)) {
                return mid;
            }
            if (words[mid].compareTo(s) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        Solution_314 solution = new Solution_314();
        String[] words_1 = { "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "" };
        String[] words_2 = { "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "" };
        String s_1 = "ta", s_2 = "ball";
        System.out.println(solution.findString(words_1, s_1));
        System.out.println(solution.findString(words_2, s_2));
    }
}