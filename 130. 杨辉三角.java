import java.util.*;

// 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。

// 在杨辉三角中，每个数是它左上方和右上方的数的和。

// 示例:

// 输入: 5
// 输出:
// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]

class Solution_130 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            List<Integer> lookUp = new ArrayList<Integer>();
            if (i > 2) {
                lookUp = ans.get(i - 2);
            }
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    temp.add(1);
                } else {
                    temp.add(lookUp.get(j - 1) + lookUp.get(j));
                }
            }
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String args[]) {
        Solution_130 solution = new Solution_130();
        int numRows = 5;
        System.out.println(solution.generate(numRows).toString());
    }
}