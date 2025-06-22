package leetcode.algorithm.listnode;

import leetcode.editor.common.ListNode;

/**
 * 92 反转链表 II
 */
public class ReverseLinkedListIi_92 {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummyNode = new ListNode(-1,head);
            ListNode pre = dummyNode;

            // 1、找到left的前一个节点
            for (int i = 0; i < left - 1; i++) {
                pre = pre.next;
            }

            // 2、找到right的节点
            ListNode rightNode = pre;
            for (int i = 0; i < right - left + 1; i++) {
                rightNode = rightNode.next;
            }

            // 3、找到left节点 和 right节点的下一个节点
            ListNode leftNode = pre.next;
            ListNode rightNodeNext = rightNode.next;

            // 4、切断left和right之间的连接
            pre.next = null;
            rightNode.next = null;

            // 5、反转left和right之间的链表
            ListNode cur = leftNode;
            ListNode preNode = null;
            while(cur != null) {
                ListNode temp = cur.next;
                cur.next = preNode;
                preNode = cur;
                cur = temp;
            }

            // 6、连接left和right之间的链表
            pre.next = rightNode;
            leftNode.next = rightNodeNext;

            return dummyNode.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi_92().new Solution();
        // put your test code here
        
    }
}