import java.util.*;

// 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

// 说明: 叶子节点是指没有子节点的节点。

// 示例:
// 给定如下二叉树，以及目标和 sum = 22，

//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \    / \
//         7    2  5   1
// 返回:

// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]

class Solution_126 {
    List<List<Integer>> path_list = new ArrayList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        getPath(new Stack<Integer>(), root, sum);
        return path_list;
    }

    public void getPath(Stack<Integer> path, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        int res = sum - root.val;
        path.push(root.val);
        if (res == 0 && root.left == null && root.right == null) {
            path_list.add(new ArrayList<Integer>(path));
        } else {
            getPath(path, root.left, res);
            getPath(path, root.right, res);
        }
        path.pop();
    }

    public static void main(String args[]) {
    }
}