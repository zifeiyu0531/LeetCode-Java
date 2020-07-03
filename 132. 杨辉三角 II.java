import java.util.*;

// 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。

// 在杨辉三角中，每个数是它左上方和右上方的数的和。

// 示例:

// 输入: 3
// 输出: [1,3,3,1]
// 进阶：

// 你可以优化你的算法到 O(k) 空间复杂度吗？

class Solution_132 {
    List<Integer> num_List;
    int row = 0;

    public List<Integer> getRow(int rowIndex) {
        num_List = new ArrayList<Integer>();
        if (rowIndex < 0) {
            return num_List;
        }
        row = rowIndex;
        addNum(0);
        return num_List;
    }

    public void addNum(int index) {
        if (index > row) {
            return;
        }
        List<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i <= index; i++) {
            if (i == 0 || i == index) {
                temp.add(1);
            } else {
                temp.add(num_List.get(i) + num_List.get(i - 1));
            }
        }
        num_List = temp;
        index++;
        addNum(index);
    }

    public static void main(String args[]) {
        Solution_132 solution = new Solution_132();
        int rowIndex = 3;
        System.out.println(solution.getRow(rowIndex).toString());
    }
}