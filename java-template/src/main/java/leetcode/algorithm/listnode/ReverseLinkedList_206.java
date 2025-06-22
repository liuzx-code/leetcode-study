package leetcode.algorithm.listnode;

import leetcode.editor.common.ListNode;

/**
 * 206 反转链表
 */
public class ReverseLinkedList_206 {

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
        public ListNode reverseList(ListNode head) {
                ListNode cur = head, pre = null;
                while(cur != null) {
                    ListNode temp = cur.next; // 暂存后继节点
                    cur.next = pre; // cur 指向 pre
                    pre = cur; // pre 后移 准备给下一个节点使用
                    cur = temp; // cur 后移
                }
                return pre;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList_206().new Solution();
        // put your test code here
        
    }
}