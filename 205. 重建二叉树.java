// 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

//  

// 例如，给出

// 前序遍历 preorder = [3,9,20,15,7]
// 中序遍历 inorder = [9,3,15,20,7]
// 返回如下的二叉树：

//     3
//    / \
//   9  20
//     /  \
//    15   7
//  

// 限制：

// 0 <= 节点个数 <= 5000

// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode(int x) { val = x; }
//  * }
//  */
class Solution_205 {

    private int start = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return getRoot(preorder, inorder, 0, preorder.length - 1);
    }

    private TreeNode getRoot(int[] preorder, int[] inorder, int left, int right) {
        if (left > right) {
            start--;
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int index = 0;
        for (int i = left; i <= right; i++) {
            if (inorder[i] == preorder[start]) {
                index = i;
                break;
            }
        }
        start++;
        root.left = getRoot(preorder, inorder, left, index - 1);
        start++;
        root.right = getRoot(preorder, inorder, index + 1, right);
        return root;
    }

    public static void main(String args[]) {
    }
}