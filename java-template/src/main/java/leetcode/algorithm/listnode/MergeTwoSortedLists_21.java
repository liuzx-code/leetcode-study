package leetcode.algorithm.listnode;

import leetcode.editor.common.ListNode;

/**
 * 21 . 合并两个有序链表
 */
public class MergeTwoSortedLists_21 {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            }
            else if (list2 == null) {
                return list1;
            }
            else if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists_21().new Solution();
        // put your test code here

    }
}