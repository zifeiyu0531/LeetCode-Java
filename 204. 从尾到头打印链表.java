// 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

//  

// 示例 1：

// 输入：head = [1,3,2]
// 输出：[2,3,1]
//  

// 限制：

// 0 <= 链表长度 <= 10000

// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode(int x) { val = x; }
//  * }
//  */
class Solution_204 {
    public int[] reversePrint(ListNode head) {
        ListNode p = head;
        int count = 0;
        while (p != null) {
            p = p.next;
            count++;
        }
        int[] res = new int[count];
        p = head;
        for (int i = count - 1; i >= 0; i--) {
            res[i] = p.val;
            p = p.next;
        }
        return res;
    }

    public static void main(String args[]) {
    }
}