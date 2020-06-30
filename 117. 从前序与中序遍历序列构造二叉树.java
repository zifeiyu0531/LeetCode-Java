// 根据一棵树的前序遍历与中序遍历构造二叉树。

// 注意:
// 你可以假设树中没有重复的元素。

// 例如，给出

// 前序遍历 preorder = [3,9,20,15,7]
// 中序遍历 inorder = [9,3,15,20,7]
// 返回如下的二叉树：

//     3
//    / \
//   9  20
//     /  \
//    15   7

class Solution_117 {
    int i = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) {
            return null;
        }
        TreeNode root = getRoot(preorder, inorder, 0, n - 1);
        return root;
    }

    public TreeNode getRoot(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            i--;
            return null;
        }
        int index = start;
        while (preorder[i] != inorder[index]) {
            index++;
        }
        TreeNode root = new TreeNode(inorder[index]);
        i++;
        root.left = getRoot(preorder, inorder, start, index - 1);
        i++;
        root.right = getRoot(preorder, inorder, index + 1, end);
        return root;
    }

    public static void main(String args[]) {
    }
}