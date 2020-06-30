// 根据一棵树的中序遍历与后序遍历构造二叉树。

// 注意:
// 你可以假设树中没有重复的元素。

// 例如，给出

// 中序遍历 inorder = [9,3,15,20,7]
// 后序遍历 postorder = [9,15,7,20,3]
// 返回如下的二叉树：

//     3
//    / \
//   9  20
//     /  \
//    15   7

class Solution_118 {
    int i;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if (n == 0) {
            return null;
        }
        i = n - 1;
        TreeNode root = getRoot(inorder, postorder, 0, n - 1);
        return root;
    }

    public TreeNode getRoot(int[] inorder, int[] postorder, int start, int end) {
        if (start > end) {
            i++;
            return null;
        }
        int index = start;
        while (inorder[index] != postorder[i]) {
            index++;
        }
        TreeNode root = new TreeNode(inorder[index]);
        i--;
        root.right = getRoot(inorder, postorder, index + 1, end);
        i--;
        root.left = getRoot(inorder, postorder, start, index - 1);
        return root;
    }

    public static void main(String args[]) {
    }
}