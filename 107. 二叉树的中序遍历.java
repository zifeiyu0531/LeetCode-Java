import java.util.*;

// 给定一个二叉树，返回它的中序 遍历。

// 示例:

// 输入: [1,null,2,3]
//    1
//     \
//      2
//     /
//    3

// 输出: [1,3,2]
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？

class Solution_107 {
    List<Integer> ans;

    public List<Integer> inorderTraversal(TreeNode root) {
        ans = new ArrayList<Integer>();
        getList(root);
        return ans;
    }

    public void getList(TreeNode root) {
        if (root == null) {
            return;
        }
        getList(root.left);
        ans.add(root.val);
        getList(root.right);
    }

    public static void main(String args[]) {
    }
}