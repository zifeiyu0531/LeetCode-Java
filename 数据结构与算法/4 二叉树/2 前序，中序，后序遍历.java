// 二叉树节点BTNode
class BTNode<T> {
    T val;
    BTNode<T> left;
    BTNode<T> right;

    public BTNode() {
        this(null);
    }

    public BTNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class MyTreeOrder {
    /**
     * 二叉树前序遍历：先访问根节点，再访问左子树，最后访问右子树
     * 
     * @param root 二叉树根节点
     * @return 前序遍历字符串
     */
    public String preOrder(BTNode<Character> root) {
        String str = "";
        if (root != null) {
            str += root.val + " ";
            str += preOrder(root.left);
            str += preOrder(root.right);
        }
        return str;
    }

    /**
     * 二叉树中序遍历：先访问左子树，再访问根节点，最后访问右子树
     * 
     * @param root 二叉树根节点
     * @return 中序遍历字符串
     */
    public String inOrder(BTNode<Character> root) {
        String str = "";
        if (root != null) {
            str += inOrder(root.left);
            str += root.val + " ";
            str += inOrder(root.right);
        }
        return str;
    }

    /**
     * 二叉树后序遍历：先访问左子树，再访问右子树，最后访问根节点
     * 
     * @param root 二叉树根节点
     * @return 后序遍历字符串
     */
    public String postOrder(BTNode<Character> root) {
        String str = "";
        if (root != null) {
            str += postOrder(root.left);
            str += postOrder(root.right);
            str += root.val + " ";
        }
        return str;
    }
}