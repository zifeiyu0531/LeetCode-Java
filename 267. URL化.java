// URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）

//  

// 示例 1：

// 输入："Mr John Smith    ", 13
// 输出："Mr%20John%20Smith"
// 示例 2：

// 输入："               ", 5
// 输出："%20%20%20%20%20"
//  

// 提示：

// 字符串长度在 [0, 500000] 范围内。
class Solution_267 {
    public String replaceSpaces(String S, int length) {
        return S.substring(0, length).replace(" ", "%20");
    }

    public static void main(String args[]) {
        Solution_267 solution = new Solution_267();
        String S_1 = "Mr John Smith    ", S_2 = "               ";
        int length_1 = 13, length_2 = 5;
        System.out.println(solution.replaceSpaces(S_1, length_1));
        System.out.println(solution.replaceSpaces(S_2, length_2));
    }
}