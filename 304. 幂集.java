import java.util.*;

// 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。

// 说明：解集不能包含重复的子集。

// 示例:

//  输入： nums = [1,2,3]
//  输出：
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]
class Solution_304 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> tempList, int[] nums, int start) {
        res.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            dfs(res, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String args[]) {
        Solution_304 solution = new Solution_304();
        int[] nums = { 1, 2, 3 };
        System.out.println(solution.subsets(nums).toString());
    }
}