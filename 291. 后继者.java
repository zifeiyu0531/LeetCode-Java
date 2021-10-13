import jdk.nashorn.api.tree.Tree;

// 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。

// 如果指定节点没有对应的“下一个”节点，则返回null。

// 示例 1:

// 输入: root = [2,1,3], p = 1

//   2
//  / \
// 1   3

// 输出: 2
// 示例 2:

// 输入: root = [5,3,6,2,4,null,null,1], p = 6

//       5
//      / \
//     3   6
//    / \
//   2   4
//  /   
// 1

// 输出: null
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution_291 {
    boolean flag = false;
    TreeNode target = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inOrder(root, p);
        return target;
    }

    private void inOrder(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        inOrder(root.left, p);
        if (flag == true) {
            target = root;
            flag = false;
            return;
        }
        if (root == p) {
            flag = true;
        }
        inOrder(root.right, p);
    }

    public static void main(String args[]) {
    }
}