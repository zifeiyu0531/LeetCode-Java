// 给定一棵二叉搜索树，请找出其中第k大的节点。

//  

// 示例 1:

// 输入: root = [3,1,4,null,2], k = 1
//    3
//   / \
//  1   4
//   \
//    2
// 输出: 4
// 示例 2:

// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//        5
//       / \
//      3   6
//     / \
//    2   4
//   /
//  1
// 输出: 4
//  

// 限制：

// 1 ≤ k ≤ 二叉搜索树元素个数
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_230 {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }

    public static void main(String args[]) {
    }
}