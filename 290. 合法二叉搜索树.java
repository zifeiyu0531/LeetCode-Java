// 实现一个函数，检查一棵二叉树是否为二叉搜索树。

// 示例 1:
// 输入:
//     2
//    / \
//   1   3
// 输出: true
// 示例 2:
// 输入:
//     5
//    / \
//   1   4
//      / \
//     3   6
// 输出: false
// 解释: 输入为: [5,1,4,null,null,3,6]。
//      根节点的值为 5 ，但是其右子节点值为 4 。
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution_290 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        Integer val = root.val;
        if (lower != null && lower >= val) {
            return false;
        }
        if (upper != null && upper <= val) {
            return false;
        }
        return helper(root.left, lower, val) && helper(root.right, val, upper);
    }

    public static void main(String args[]) {
    }
}