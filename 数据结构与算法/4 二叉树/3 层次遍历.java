import java.util.*;

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

class MyLevelOrder {
    /**
     * 二叉树层次遍历：按层访问所有节点
     * 
     * @param root 二叉树根节点
     * @return 层次遍历字符串
     */
    public String levelOrder(BTNode<Character> root) {
        if (root == null) {
            return "";
        }
        Deque<BTNode<Character>> queue = new LinkedList<BTNode<Character>>();
        queue.add(root);
        String str = "";
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BTNode<Character> node = queue.removeFirst();
                str += node.val + " ";
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
        }
        return str;
    }
}